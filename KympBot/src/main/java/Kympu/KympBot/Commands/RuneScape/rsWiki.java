package Kympu.KympBot.Commands.RuneScape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.Commands.Other.GoogleFetch;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class rsWiki {
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
				Elements titleDig = doc2.select("div.WikiaPageContentWrapper h1");
				String Title = titleDig.text();
				Title = Title.replaceAll(" Fan Feed", "");
				//Image
				String imgUrl = "";
				Boolean imgT = true;
				try{
				Elements imgDig = doc2.select("div.infobox-wrapper table tbody tr td");
				Element imgLink = imgDig.select("a").first();
				imgUrl = imgLink.attr("abs:href");
				}catch(Exception ex){
					Elements imageDig = doc2.select("div.WikiaPageContentWrapper");
					Element imageFirst = imageDig.select("a[href].image").first();
					imgUrl = imageFirst.attr("abs:href");
				}
			
				//Content
				String content = null;
				try{
				Elements contentDig = doc2.select("div.WikiaMainContentContainer div.mw-content-text");
				Element contentF = contentDig.select("div.floatleft + p").first();
				content = contentF.text();
				}catch(Exception ex){
					Elements contentDig = doc2.select("div.mw-content-text");
					Element contentFirst = contentDig.select("p:contains(" + Title +")").first();
					content = contentFirst.text();
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
					sideImage = false;
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
				EmbedBuilder eb = new EmbedBuilder();
					eb.setTitle("Error occured");
					eb.setDescription("No information found!");
					embed = eb.build();
			}
			
		}
		catch(Exception ex){
			EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle("Error occured");
				eb.setDescription("No information found!");
				embed = eb.build();
		}
		
		return embed;
	}
}
