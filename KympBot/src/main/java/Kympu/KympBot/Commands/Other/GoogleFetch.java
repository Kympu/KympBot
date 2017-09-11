package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.App;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GoogleFetch {
	public String Message(MessageReceivedEvent e){
		String SearchType = App.Pass();
		String MessageSend = "";
		Message objMsg = e.getMessage();
		String finalLink = "";
		String Message = objMsg.getContent();
		String Search = Message.toString().toLowerCase()
				.replaceAll("!wiki ", "")
				.replaceAll(" ", "+");
		
		String GoogleLink = "https://www.google.com/search?q=";	    			
		String GoogleSearch = GoogleLink + SearchType + "+" + Search;
		Document doc = null;	
			try {
				doc = Jsoup.connect(GoogleSearch).get();
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
			Elements urlDig = doc.select("div#rcnt");						
			Element link = urlDig.select("div.med div._NId div.rc h3.r a").first();
				finalLink = link.attr("abs:href");
				MessageSend = finalLink;
				
		return MessageSend;
	}
}
