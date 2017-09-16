package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class weather {
	public MessageEmbed Message(MessageReceivedEvent e){
		
		Message objMsg = e.getMessage();
		MessageEmbed embed = null;
		String finalLink = "";		
		String Message = objMsg.getContent();
		String Search = Message.toString().toLowerCase()
				.replaceAll("!weather ", "")
				.replaceAll(" ", "+");
		
		String GoogleLink = "https://www.google.com/search?q=weather+";	    			
		String GoogleSearch = GoogleLink + Search;
		Document doc = null;
		try{	
			try {
				doc = Jsoup.connect(GoogleSearch).get();
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
			Document doc2 = doc;
			try{	

				Elements googleDig = doc2.select("div#wob_wc");
				Element titleDig = googleDig.select("div#wob_loc").first();				
					String Title = titleDig.text();
				
				Element timeDig = googleDig.select("div#wob_dts").first();
					String Time = timeDig.text();
					
				Element condDig = googleDig.select("div#wob_dcp").first();
					String Condition = condDig.text();
					
				Element picDig = googleDig.select("div#wob_d img").first();
					String imageIcon = picDig.attr("src");
					imageIcon = imageIcon.replaceAll("//ssl.", "http://www.");
					
				Element tempDigCels = googleDig.select("div.vk_bk span").first();
					String tempCels = tempDigCels.text();
					
				Element tempDigFar = googleDig.select("div.vk_bk span + span").first();
					String tempFar = tempDigFar.text();
					
				Element extraInfoDig1 = googleDig.select("div.wob-dtl div").first();
					String extraInfo1 = extraInfoDig1.text();
				Element extraInfoDig2 = googleDig.select("div.wob-dtl div + div").first();
					String extraInfo2 = extraInfoDig2.text();	
				Element extraInfoDig3 = googleDig.select("div.wob-dtl div + div + div").first();
					String extraInfo3 = extraInfoDig3.text();
						extraInfo3 = extraInfo3.replace("km/h", "km/h or ");
						String extraInfos = extraInfo1 + " | " + extraInfo2 + " | " + extraInfo3  ;
			
				
				String fullTemp = tempCels + " °C | " + tempFar + " °F";
				String Content = Time + "\n" + Condition  + "\n" + extraInfos;
				
				EmbedBuilder eb = new EmbedBuilder();
					eb.setTitle(Title + " ~ " + fullTemp);
					eb.setDescription(Content);
	    			eb.setThumbnail(imageIcon);
	    			embed = eb.build();
			}
				
			catch(Exception ex){
				EmbedBuilder eb = new EmbedBuilder();
					eb.setTitle("Error occured");
					eb.setDescription("No information found!");
					embed = eb.build();
				System.out.println("[Weather] Could not fetch the informaton.");
			}
			
		}
		catch(Exception ex){
			EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle("Error occured");
				eb.setDescription("No information found!");
				embed = eb.build();
			System.out.println("[Weather] Could not connect to google link.");
		}	
		
		return embed;
	}
}
