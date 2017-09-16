package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class urban {
	public MessageEmbed Message(MessageReceivedEvent e){
		EmbedBuilder eb = new EmbedBuilder();
		MessageEmbed embed = null;
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
			eb.setTitle("From Urban Dicteonary ~ " + Searching);
			eb.setDescription("\n\n" + Send2);
			eb.setThumbnail("http://www.userlogos.org/files/logos/WoolfBeng/urban1.png");
			embed = eb.build();					
		}
	}
	catch(Exception ex){
		eb.setTitle("From Urban Dicteonary");
		eb.setDescription("Article too long." + "\n\n" + UrbanSearch);
		eb.setThumbnail("http://www.userlogos.org/files/logos/WoolfBeng/urban1.png");
		embed = eb.build();		
		
	}	    		
		
		return embed;
	}
}
