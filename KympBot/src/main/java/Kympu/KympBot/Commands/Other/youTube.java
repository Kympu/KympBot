package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class youTube {
	public String Message(MessageReceivedEvent e){
		///////////////////NOT WORKING RN////////////////////
		String Send = "";
		Message objMsg = e.getMessage();
		String YouTubeLink = null;
		String Message = objMsg.getContent();
		YouTubeLink = "https://www.youtube.com/results?sp=EgIQAQ%253D%253D&q=";
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
				
				Elements urlDig = doc.select("div#content div#container div#primary div#contents");	
				System.out.println("In Class Url Dig: " + urlDig);								
					Element method2 = urlDig.select("div.yt-lockup-content h3").first();
					Elements Link = method2.select("a[href]");				
					String FinalLink = Link.attr("href");
					Send = YouTube + FinalLink;
					
    			
			}
			
		catch(Exception ex){
			Send = "No information found!";
		} 
		
		return Send;
	}
}
