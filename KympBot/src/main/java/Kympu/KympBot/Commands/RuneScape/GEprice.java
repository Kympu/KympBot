package Kympu.KympBot.Commands.RuneScape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.Commands.Other.GoogleFetch;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GEprice {
	public MessageEmbed Message(MessageReceivedEvent e){
		MessageEmbed embed = null;
		GoogleFetch Link = new GoogleFetch();
		String finalLink = Link.Message(e);
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
				String Title = TitleDig.text();
				
				//Image
				Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
				Element imageFirst = imageDig.select("a").first();
				String imageUrl = imageFirst.attr("abs:href");		
				
				//GE price
				Elements urlDigW = doc2.select("div.infobox-wrapper tr span.infobox-quantity span");
				String urlDigW2 = urlDigW.text();
				
				//High ALch
				String HighAlch = "";

				Elements HighAlchDig = doc2.select("div.infobox-wrapper tr:contains(high) td");
				HighAlch = HighAlchDig.text(); 
				if(HighAlch == null){
					HighAlch = "Cannot Alch";
				}
				
				//Price Change
				Elements infoDig = doc2.select("div.infobox-wrapper tr span.infobox-quantity a");
				Element infoLink = infoDig.select("a[href]").first();
				String infoLink2 = infoLink.attr("abs:href");
					Document doc3 = null;
					doc3 = Jsoup.connect(infoLink2).get();
					Elements GELink = doc3.select("div.WikiaSiteWrapper section#WikiaPage div.WikiaPageContentWrapper "
							+ "article#WikiaMainContent table.wikitable tbody tr td ul li a:contains(Look up current price)");
					Element GELink2 = GELink.select("a[href]").first();
					String GEfinalLink = GELink2.attr("abs:href");
						Document doc4 = null;
						doc4 = Jsoup.connect(GEfinalLink).get();
						Elements prChange = doc4.select("li:contains(Today) span span");
						String todayChange = prChange.text();
				
						String Symbol = "";
						if(todayChange.startsWith("-")){
							Symbol = ":chart_with_downwards_trend:";
						}
						else{
							Symbol = ":chart_with_upwards_trend:";
						}
						String SymbolM = "";
						Elements prMChange = doc4.select("li:contains(1 Month) span span");
						String monthChange = prMChange.text();
							if(monthChange.startsWith("-")){
								SymbolM = ":chart_with_downwards_trend:";
							}
							else{
								SymbolM = ":chart_with_upwards_trend:";
							}
							
							EmbedBuilder eb = new EmbedBuilder();
							Title = Title.replaceAll(" Fan Feed", "");
			    			String endContent = "**" + Title + ": **" + urlDigW2 + " coins" 
    								+ "\n" + Symbol + "**Today's Change: **" + todayChange
    								+ "\n" + SymbolM + "**1 Month Change: **" + monthChange
    								+ "\n**High Alch: **" + HighAlch;
			    			
							eb.setDescription(endContent);
			    			eb.setThumbnail(imageUrl);
			    			embed = eb.build();				
			}
				
			catch(Exception ex){
				EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle("Error occured");
				eb.setDescription("No Item Found!");
				embed = eb.build();
			}
			
		}
		catch(Exception ex){
		
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("Error occured");
			eb.setDescription("No Item Found!");
			embed = eb.build();
		
		}
		
		return embed;
	}
}
