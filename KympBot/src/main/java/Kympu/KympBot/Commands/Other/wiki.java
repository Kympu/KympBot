package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class wiki {
	public MessageEmbed Message(MessageReceivedEvent e){
		MessageEmbed embed = null;
		String finalLink = "";
		try{	
			
			GoogleFetch Link = new GoogleFetch();
			finalLink = Link.Message(e);
			
			Document doc2 = null;
			try{	
				try {
					doc2 = Jsoup.connect(finalLink).get();
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
			
				//Title
				Elements titleDig = doc2.select("h1.firstHeading");
				String Title = titleDig.text();
				
				//Image
				String imgUrl = "";
				Boolean imgT = true;
				try{
				Elements imgDig = doc2.select("div#content");
				Element imgLink = imgDig.select("tbody a.image img").first();
				imgUrl = imgLink.attr("abs:src");
				}catch(Exception ex){
					try{
    					Elements imgDig = doc2.select("div#content");
    					Element imgLink = imgDig.select("a.image img").first();
    					imgUrl = imgLink.attr("abs:src");
    					}catch(Exception e1){
    						imgT = false;
    					}
				}
			
				//Content
				String content = null;
				try{
				Elements contentDig = doc2.select("div#content");
				Element contentF = contentDig.select("p").first();
				content = contentF.text();
				}catch(Exception ex){
					EmbedBuilder Error = new EmbedBuilder();
					Error.setDescription("No information found!");
					embed = Error.build();
				}
				EmbedBuilder eb = new EmbedBuilder();
				
				//Side image
				String imageUrl2 = null;
				Boolean sideImage = true;
				try{
				Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
				Element imageFirst = imageDig.select("a").first();
				imageUrl2 = imageFirst.attr("abs:href");
				}catch(Exception ex){
					imageUrl2 = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Wikipedia_Logo_1.0.png/220px-Wikipedia_Logo_1.0.png";
				}
				
				eb.setTitle(Title);
				eb.setDescription(content + "\n\n**More at: **" + finalLink);
				if(sideImage){
				eb.setThumbnail(imageUrl2);
				}
				if(imgT){
    			eb.setImage(imgUrl);
				}
    			embed = eb.build();
    			
			}
				
			catch(Exception ex){
				EmbedBuilder Error = new EmbedBuilder();
				Error.setDescription("No information found!");
				embed = Error.build();
			}
			
		}
		catch(Exception ex){
			EmbedBuilder Error = new EmbedBuilder();
			Error.setDescription("No information found!");
			embed = Error.build();
		}
		
		return embed;
	}
}
