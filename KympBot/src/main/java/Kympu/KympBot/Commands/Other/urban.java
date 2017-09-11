package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class urban {
	public String Message(MessageReceivedEvent e){
		String Send = "";
		Message objMsg = e.getMessage();
		String input = objMsg.getContent();
		String UrbanLink = "http://www.urbandictionary.com/define.php?term=";	    			
		String Search = input.toLowerCase().toString()
				.replaceAll("!urban ", "")
				.replaceAll(" ", "+");
		
		String lookup = Search;		    			
		String UrbanSearch = UrbanLink + lookup;		
		
		Document doc = null;
	try{	
		try {
			doc = Jsoup.connect(UrbanSearch).get();
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		Elements body = doc.select("div#content");
		for(Element content : body){												
			Element urlDig = content.select("div.meaning").first();
			String urlDig2 = urlDig.toString();
			String Send2 = Jsoup.parse(urlDig2).text();					
			String Searching = input.toString()
					.replaceAll("!urban", "")
					.replaceAll("!Urban", "");
			
			Send = "```From Urban dictionary\n\nSearching:" + Searching + "\n\n" + Send2 + "```";					
		}
	}
	catch(Exception ex){
		Send = "Article too long! \n" + UrbanSearch;
	}	    		
		
		return Send;
	}
}
