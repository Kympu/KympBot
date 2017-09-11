package Kympu.KympBot;

import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;

public class TestBot {
	public static void main(String[] args){
		
		String Send = "";
		String YouTubeLink = null;
		String Message = "captain sparklez";
		YouTubeLink = "https://www.youtube.com/results?search_query=";
		String YouTube = "https://www.youtube.com";	    
		
		String Search = Message.toLowerCase().toString()
				.replaceAll("!youtube ", "")
				.replaceAll("!yt ", "")
				.replaceAll(" ", "+");
		if(Search.contains("#playlist ")){
			Search = Search.toString()
    				.replaceAll("#playlist", "");
			YouTubeLink = "https://www.youtube.com/results?sp=EgIQAw%253D%253D&q="; 
			}
		if(Search.contains("#new")){
			Search = Search.toString()
    				.replaceAll("#new ", "");
			YouTubeLink = "https://www.youtube.com/results?sp=EgIIAw%253D%253D&q=";		    			
			}
		
			String YouTubeSearch = YouTubeLink + Search;
			System.out.println("In Class YT Search: " + YouTubeSearch);
			Document doc = null;
			try{	
    			
				doc = Jsoup.connect(YouTubeSearch).get();
				
				Elements urlDig = doc.select("div#tv-queue-title-msg");	
				System.out.println("In Class Url Dig: " + urlDig);
				  	//PrintWriter writer = new PrintWriter("C:/Users/Eric/Desktop/test.txt");
				  	 //writer.println(doc);
					Element method2 = urlDig.select("div.yt-lockup-content h3").first();
					Elements Link = method2.select("a[href]");				
					String FinalLink = Link.attr("href");
					Send = YouTube + FinalLink;
					
    			
			}
			
		catch(Exception ex){
			Send = "No information found!";
		} 
		
	}
}
