package Kympu.KympBot.Commands.Other;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.App;
import Kympu.KympBot.Console.mainConsole;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GoogleFetch {
	static String passToConsole = "";
	public String Message(MessageReceivedEvent e){
		User getUser = e.getAuthor();
			String getUserID = e.getAuthor().getAsMention();
			String User = getUser.toString();
				User = User.replace("(","").replace(")","").replace("U:", "");
				getUserID = getUserID
						.replaceAll("<", "(")
						.replaceAll("@", "")
						.replaceAll(">", ")");
				User = User.replaceAll(getUserID, "");
		
		Date Current = new Date();
        DateFormat df = new SimpleDateFormat("[hh:mm:ss]");//MM-dd-yy h:mm a
		String sysTime = df.format(Current);
        
		String SearchType = App.Pass();
		String MessageSend = "";
		Message objMsg = e.getMessage();
		String ErrorMsg = "Command Success";
		String finalLink = "";
		String Message = objMsg.getContent();
		String Command = Message.split(" ")[0];
		String Search = Message.toString().toLowerCase()
				.replaceAll(Command + " ", "")
				.replaceAll(" ", "+");
		String msgInput = Message.toString().replace(Command + " ", "");
		String GoogleLink = "https://www.google.com/search?q=";	    			
		String GoogleSearch = GoogleLink + SearchType + "+" + Search;
		Document doc = null;	
			try {
				doc = Jsoup.connect(GoogleSearch).get();
			} catch (Exception ex) {
				ErrorMsg = "Could not connect to the link ";
				ex.printStackTrace();
			}
			Elements urlDig = doc.select("div#rcnt");						
			Element link = urlDig.select("div.med div._NId div.rc h3.r a").first();
				finalLink = link.attr("abs:href");
				MessageSend = finalLink;
				//passToConsole = sysTime +  " [" + User + "]" + " [" + Command + "] " + " Input: " + msgInput;
				mainConsole PassTo = new mainConsole();
				//PassTo.sendToConsole();
				
				//System.out.println(passToConsole);
				
		return MessageSend;
	}
	
	/*public static String toConsole(){		
		return passToConsole;
	}*/
	
	
}
