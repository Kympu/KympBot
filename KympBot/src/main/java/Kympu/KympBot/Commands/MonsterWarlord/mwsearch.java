package Kympu.KympBot.Commands.MonsterWarlord;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class mwsearch {
	public String Message(MessageReceivedEvent e){
		Message objMsg = e.getMessage();
		String Message = "";
		String input = objMsg.getContent();
		String Search = input.toString()
				.replaceAll(" ", "+");
		
		String GoogleLink = "https://www.google.com/search?q=wiki+monster+warlord";
			
			String lookup = Search.toLowerCase()
    				.replaceAll("!mwsearch", "");
			
			String GoogleSearch = GoogleLink + lookup;		
			
			Document site = null;
		try{	
			try {
				site = Jsoup.connect(GoogleSearch).get();
			} catch (Exception ex) {
				System.err.print("\nError while fetching Google search link: " + GoogleSearch);
			}
			Elements body = site.select("div#rcnt");
			Elements urlDig = body.select("div#center_col");								
			for(Element context : urlDig){												

				String search = "wiki";								
				Element link = site.select("div.med div._NId h3 a:contains("+ search + ")").first();
				String finalLink = link.attr("abs:href");
				if(finalLink == ("http://monsterwarlord.wikia.com/")){
					Message = "No information found!";
					break;						
				}
				Message = finalLink;			
			}
		}
		catch(Exception ex){
			Message = "No information found!";
		}	   
		return Message;
	}
}
