package Kympu.KympBot.Commands.RuneScape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.Commands.Other.GoogleFetch;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Slayer {
	public MessageEmbed Message(MessageReceivedEvent e){
		
		MessageEmbed embed = null;
		GoogleFetch Link = new GoogleFetch();
		String finalLink =  Link.Message(e);
		String Content2 = "";
		try{			
			Document doc2 = null;
			try{	
				try {
					doc2 = Jsoup.connect(finalLink).get();
				} catch (Exception ex) {
					
					System.out.println("Could not fetch the link: " + finalLink);
				}
				Elements urlDigW = doc2.select("div.mw-content-text h2:contains(Location) + ul li");
				//System.out.println(finalLink);
				//Title
				Elements titleDig = doc2.select("div.infobox-wrapper table caption");
				String Title = titleDig.text();
				//System.out.println(Title);
				//Image
				Elements imgDig = doc2.select("div.infobox-wrapper table tbody tr td");
				Element imgLink = imgDig.select("a").first();
				String imgUrl = imgLink.attr("abs:href");
				//System.out.println(imgUrl);
				//XP
				Elements xpDig = doc2.select("div.infobox-wrapper table tbody tr");
					//Combat XP
				Element cmbXPDig = xpDig.select("td.mob-cb-xp").first();
				String cmbXP = cmbXPDig.text();
					//HP XP
				Element hpXPDig = xpDig.select("td.mob-hp-xp").first();
				String hpXP = hpXPDig.text();
					//Slayer XP
				Element slayXPDig = xpDig.select("td.mob-slay-xp").first();
				String slayXP = slayXPDig.text();
				//System.out.println(slayXP);
				//Content
				try{
				Elements contentDig = doc2.select("div.WikiaPageContentWrapper div#mw-content-text");
				Element contentFirst = contentDig.select("div.floatleft + p").first();
				Content2 = contentFirst.text();
				//System.out.println(Content2);
				}catch(Exception ex){
					Elements contentDig = doc2.select("div.WikiaPageContentWrapper div#mw-content-text");
					Element contentFirst = contentDig.select("div#mw-content-text p:contains(" + Title + "s" +")").first();
					Content2 = contentFirst.text();
					//System.out.println(Content2);
				}
				//Weakness
				Elements weakDig = doc2.select("div.infobox-wrapper table tbody tr:contains(weakness) + tr td + td + td");
				Element Redir = weakDig.select("a[href]").first();
				String Red = Redir.attr("abs:href");
				Document WeakRed = null;
				WeakRed = Jsoup.connect(Red).get();
				Elements weaknDig = WeakRed.select("div.WikiaPageContentWrapper h1");
				String Weakness = weaknDig.text();
				Weakness = Weakness.replaceAll(" Fan Feed", "");
				if(Weakness.contains("Weakness")){
					Weakness = "No Weakness";
				}
				//System.out.print(Weakness);
				
				//Locations http://runescape.wikia.com/wiki/Slayer_monsters
				doc2 = Jsoup.connect("http://runescape.wikia.com/wiki/Slayer_monsters").get();
				Elements locDig = doc2.select("div.mw-content-text h2:contains(Location) + h3");
				String Location = "", Send = "";
				int i = 0;
				for(Element li : locDig){
					i++;
					Element Locat = li.select("span").first();
					Location += i + ". " + Locat.text() + "\n";
					
				}
				
				String Content = "**Combat XP:** " + cmbXP + "\n**Constitution XP:** " + hpXP
						+ "\n**Slayer XP:** " + slayXP + "\n**Weakness: **" + Weakness + "\n\n" + Content2;
				EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle(Title);
				eb.setDescription(Content);
    			eb.setThumbnail(imgUrl);
    			embed = eb.build();
    			//System.out.println(Content);
			}
				
			catch(Exception ex){
				EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle("Error occured");
				eb.setDescription("No Creature Found!");
				embed = eb.build();
			}
			
		}
		catch(Exception ex){
			EmbedBuilder eb = new EmbedBuilder();
			eb.setTitle("Error occured");
			eb.setDescription("No Creature Found!");
			embed = eb.build();
		}
		
		return embed;
	}
}
