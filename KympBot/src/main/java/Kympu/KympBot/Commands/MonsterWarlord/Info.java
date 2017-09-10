package Kympu.KympBot.Commands.MonsterWarlord;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Info {
	public String Message(MessageReceivedEvent e){		
		Message objMsg = e.getMessage();
		String completeLink = "";
		String imageUrl = "";
		String Input = objMsg.getContent();	    		
		String Modify = Input.toString()
				.replaceAll("!Info ", "")
				.replaceAll("!info ", "");
		Document site = null;
		try {
			site = Jsoup.connect("https://m.gamevilusa.com/forums/forumdisplay.php?1506-Events").get();
		} catch (IOException ex) {
			//objChannel.sendMessage("Error while obtaining forum page!").complete();
			System.err.println("Error while trying to connect to:" + site);
		}
		Elements body = site.select("div#threadlist");
		String search = Modify.toLowerCase();
		for(Element threadinfo : body){
			if(Modify == ""){    				
    			break;
    		}											
			String urlDig = threadinfo.select("div.sticky h3 a.title").text();	
		
			if(urlDig.toLowerCase().contains(search)){
		
				Element linkFetch = site.select("div.sticky h3 a:contains("+ search + ")").first();
				String siteRedirect = linkFetch.attr("abs:href");
				try {
					Document redirect = Jsoup.connect(siteRedirect).get();
					Elements urlBody2 = redirect.select("div#postlist");
					for(Element postlist : urlBody2){
						Element urlDig2 = postlist.select("div.content").first();
						Element image = urlDig2.select("img").first();
						imageUrl = image.absUrl("src");
						completeLink = urlDig2.toString()
								.replaceAll("<i>", "")
								.replaceAll("</i>", "")
								.replaceAll("<b>", "")
								.replaceAll("</b>", "")
								.replaceAll("<.*.>", "")
								.replaceAll("&gt;", ">");
						//objChannel.sendMessage(imageUrl).complete();
						//objChannel.sendMessage("```" + completeLink + "```").complete();
					}
				}catch (IOException ex) {
					//objChannel.sendMessage("Error while fetching information!").complete();
					System.err.print("\nError while fetching info from !info");
				}
			}else{
				//objChannel.sendMessage("No information found, try to enter an exact keyword fround form !Events.").complete();
			}
		}
		String Message = imageUrl + "\n```" + completeLink + "```";		
		return Message;
	}
}
