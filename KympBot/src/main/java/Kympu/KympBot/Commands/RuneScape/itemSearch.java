package Kympu.KympBot.Commands.RuneScape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.Commands.Other.GoogleFetch;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class itemSearch {
	public MessageEmbed Message(MessageReceivedEvent e){
		
		MessageEmbed embed = null;
		GoogleFetch Link = new GoogleFetch();
		String finalLink =  Link.Message(e);
		
		try{				
			Document doc2 = null;
			try{	
				try {
					doc2 = Jsoup.connect(finalLink).get();
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				//Title
				Elements TitleDig = doc2.select("div.WikiaPageContentWrapper h1");
				String Title = TitleDig.text().replaceAll(" Fan Feed", "");
				
				//Image
				Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
				Element imageFirst = imageDig.select("a").first();
				String imageUrl = imageFirst.attr("abs:href");
				
				//Content
				Elements contentDig = doc2.select("div.WikiaPageContentWrapper div.mw-content-text");
				Element contentFirst = contentDig.select("div.floatleft + p").first();
				String Content = contentFirst.text();
				
				EmbedBuilder eb = new EmbedBuilder();
					eb.setTitle(Title);
					eb.setDescription(Content);
					eb.setThumbnail(imageUrl);
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
