package Kympu.KympBot;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.Commands.Other.GoogleFetch;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;

public class TestBot {
	public static void main(String[] args){
		
		//Message objMsg = "Ogre latvia";
		MessageEmbed embed = null;
		String finalLink = "";		
		//String Message = objMsg.getContent(); 
		String Search = "weather+Ogre+latvia";
		
		String GoogleLink = "https://www.google.com/search?q=";	    			
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
				
				System.out.println(GoogleSearch);
				//Title
				Elements googleDig = doc2.select("div#wob_wc");
				Element titleDig = googleDig.select("div#wob_loc").first();				
					String Title = titleDig.text();
				
				Element timeDig = googleDig.select("div#wob_dts").first();
					String Time = timeDig.text();
					
				Element condDig = googleDig.select("div#wob_dcp").first();
					String Condition = condDig.text();
					
				Element picDig = googleDig.select("div#wob_d img").first();
					String imageIcon = picDig.attr("src");
					imageIcon = imageIcon.replaceAll("//", "");
					
				Element tempDigCels = googleDig.select("div.vk_bk span").first();
					String tempCels = tempDigCels.text();
					
				Element tempDigFar = googleDig.select("div.vk_bk span + span").first();
					String tempFar = tempDigFar.text();
					
				Element extraInfoDig = googleDig.select("div.wob-dtl").first();
					String extraInfo = extraInfoDig.text();
					
				/*System.out.println("Title: " + Title);
				System.out.println("Time: " + Time);
				System.out.println("Condition: " + Condition);
				System.out.println("Picture: " + imageIcon);
				System.out.println("Temperature: " + tempCels + " | " + tempFar);
				System.out.println("Extra: " + extraInfo);*/
				
				String fullTemp = tempCels + " | " + tempFar;
				String Content = Time + "\n" + Condition + "\n" + fullTemp + "\n" + extraInfo;
				
				EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle(Title);
				eb.setDescription(Content);
    			eb.setThumbnail(imageIcon);
    			embed = eb.build();
    			//objChannel.sendMessage(embed).complete();
			}
				
			catch(Exception ex){
				//objChannel.sendMessage("No information found!").complete();
			}
			
		}
		catch(Exception ex){
			//objChannel.sendMessage("No information found!").complete();
		}	
		
	}
}
