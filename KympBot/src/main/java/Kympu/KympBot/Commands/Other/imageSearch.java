package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class imageSearch {
	public MessageEmbed Message(MessageReceivedEvent e){
		Message objMsg = e.getMessage();
		MessageEmbed embed = null;
		String Message = objMsg.getContent();
		String Search = Message.toString()
				.replaceAll("!image ", "")
				.replaceAll("!Image ", "")
				.replaceAll(" ", "+");
		
		String GoogleLinkP1 = "https://www.google.lv/search?q=";
		String GoogleLinkP2 = "&source=lnms&tbm=isch&sa";
			
			String lookup = Search;
			String GoogleSearch = GoogleLinkP1 + lookup + GoogleLinkP2;		
			
			Document doc = null;
			try{	
				try {
					doc = Jsoup.connect(GoogleSearch).get();
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				Elements body = doc.select("div#rcnt");
				Elements body2 = body.select("div#center_col");								
				for(Element context : body2){												
					Element urlDig = context.select("div.med div#rg div.rg_di img").first();
					String urlDig2 = urlDig.toString();
						urlDig2 = urlDig2.replaceAll(".*?name=", "").replaceAll("jsaction=.*.", "");
						urlDig2 = urlDig2.replaceAll("\"", "");					
					String finalLink = GoogleSearch + urlDig2;
					Document doc2 = null;
					try{
						 	doc2 = Jsoup.connect(finalLink).get(); 
					} catch (Exception ex) {
						System.err.print("\nError while fetching the image link: " + finalLink);
					}
					Elements imgbody = doc2.select("div#rcnt div#center_col div.med div#isr_mc");	    					
					Element imgmethod2 = imgbody.select("div.rg_meta").first();
					String imgmethod32 = imgmethod2.toString();
					String imgTestlink = Jsoup.parse(imgmethod32).text();	    					
						imgTestlink = imgTestlink.replaceFirst(".*?http", "http")
							.replaceFirst("\",", "\n");
						imgTestlink = imgTestlink.split("\n")[0];
					
					EmbedBuilder eb = new EmbedBuilder();
					eb.setImage(imgTestlink);
	    			embed = eb.build();
				}
			}
			catch(Exception ex){
				EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle("Error occured");
				eb.setDescription("No Image Found!");
				embed = eb.build();
			}	  		
		return embed;
	}
}
