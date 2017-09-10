package Kympu.KympBot.Commands.MonsterWarlord;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Events {	
	public String Message(){
		
	Document site = null;
	String method2 = "";
	try{ 
		site = Jsoup.connect("https://m.gamevilusa.com/forums/forumdisplay.php?1506-Events").get(); 
		}
	catch (IOException e1){ 
		System.err.print("\nError while trying to connect to:" + site);
		}
	
	Elements body = site.select("div#threadlist");									
		for(Element threadinfo : body){												
			String method = threadinfo.select("div.sticky h3.threadtitle").text();	
			method2 = method.toString()										
				.replace("Sticky: ", "\n*")											
				.replace("[Event] ", "")											
				.replace("[EVENT] ", "")											
				.replace("[LIMITED SALE] ", "");		
			}
		String Message = "```" + method2 + "```";
		return Message;
	}
}
