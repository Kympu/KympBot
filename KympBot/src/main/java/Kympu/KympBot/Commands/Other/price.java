package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class price {
	public MessageEmbed Message(MessageReceivedEvent e){
		MessageEmbed embed = null;
		Message objMsg = e.getMessage();
		String Search = objMsg.getContent().replaceAll("!price ", "").replaceAll(" ", "+");

		String itemPic = "";
		String Price = "";
		String itemLink = "";
		String finalLink = "";
		EmbedBuilder eb = new EmbedBuilder();
			Document doc2 = null;	

		try{		
				String GoogleLink = "https://www.google.com/search?q=";	    			
				String GoogleSearch = GoogleLink + "aliexpress" + "+" + Search;
				Document doc = null;	
				try {
					doc = Jsoup.connect(GoogleSearch).get();
				} catch (Exception ex) {
				//	ErrorMsg = "Could not connect to the link ";
					ex.printStackTrace();
				}
				Elements urlDig = doc.select("div#rcnt");						
				Element link = urlDig.select("div.med div._NId div.rc h3.r a:contains(aliexpress.com :)").first();
					finalLink = link.attr("abs:href");
					System.out.println(finalLink);
			try {
					doc2 = Jsoup.connect(finalLink).get();
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
			
				//Title
				
				String Title = "Result from AliExpress";
			
				//Content
				String content = null;
				try{
					Elements contentDig = doc2.select("div#content");
					Element contentF = contentDig.select("h1.product-name").first();
					Element contentPic = contentDig.select("div.detail-gallery a img").first();
					Element itemPrice = contentDig.select("div.p-current-price").first();
					
					Price = itemPrice.text();				//Item Price
					itemPic = contentPic.attr("src");		//Item Picture;
					content = contentF.text();				//Item Description
					itemLink = contentF.attr("abs:href");	//item Link
					
					eb.setTitle(Title);
					eb.setDescription(content + "\n\nPrice: " + Price + "\n\n**More at:** " + finalLink);
					eb.setImage(itemPic);
					
	    			embed = eb.build();
    			
				}
				catch(Exception ex){
					eb.setTitle("Error occured");
					eb.setDescription("No information found!");
					embed = eb.build();
				}
		}catch(Exception ex){
			eb.setTitle("Error occured");
			eb.setDescription("No information found!");
			embed = eb.build();
		}
			

			
		return embed;
	}
}
