package Kympu.KympBot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

public class TestBot {
	public static void main(String[] args){
		String finalLink = "";
		String Message = "java arraylist";
		String Search = Message.toString().toLowerCase()
				.replaceAll("!code ", "")
				.replaceAll(" ", "+");
		
		String GoogleLink = "https://www.google.com/search?q=stackoverflow+";	    			
		String GoogleSearch = GoogleLink + Search;
		Document doc = null;
		try{	
			try {
				doc = Jsoup.connect(GoogleSearch).get();
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
			Elements urlDig = doc.select("div#rcnt");
			Elements urlDig2 = urlDig.select("div#center_col");								
			for(Element context : urlDig2){																				
				String search = "overflow";								
				Element link = doc.select("div.med div._NId div.rc h3.r a:contains("+ search + ")").first();
				finalLink = link.attr("abs:href");
			System.out.println("Stack Link: " + finalLink);
				if(finalLink.contains("https://en.wikipedia.org/wiki/%")){
					//objChannel.sendMessage("No information found!").complete();
					break;						
				}
				//System.out.print(finalLink + "\n");	
				//objChannel.sendMessage(finalLink).complete();
			}
			Document doc2 = null;
			try{	
				try {
					doc2 = Jsoup.connect(finalLink).get();
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
			
				//Title
				String Title = "Answer";
			
				//Content
				String content = null;
				try{
				Elements contentDig = doc2.select("div#mainbar div#answers");
				Element contentF = contentDig.select("div.accepted-answer td.answercell div.post-text").first();
				content = contentF.text();
				//System.out.println(content);
				}catch(Exception ex){
					Elements contentDig = doc2.select("div.mw-content-text");
					Element contentFirst = contentDig.select("p:contains()").first();
					content = contentFirst.text();
				}
				EmbedBuilder eb = new EmbedBuilder();	
				
				//Side image
				String imageUrl2 = "http://www.iconsdb.com/icons/preview/green/checkmark-xxl.png";				
				
				eb.setTitle(Title);
				eb.setDescription(content + "\n\n**More at: **" + finalLink);
				eb.setThumbnail(imageUrl2);
				//if(imgT){
    			//eb.setImage(imgUrl);
				//}
    			MessageEmbed embed = eb.build();
    			//objChannel.sendMessage(embed).complete();
    			System.out.println(content);
			}
				
			catch(Exception ex){
				//objChannel.sendMessage("No information found!").complete();
				System.out.println("No info");
			}
			
		}
		catch(Exception ex){
			//objChannel.sendMessage("No information found!").complete();
			System.out.println("No info");
		}
	}
}
