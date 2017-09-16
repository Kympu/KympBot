package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class codeSearch {
	
	public MessageEmbed Question(MessageReceivedEvent e){
		
		String finalLink = "";		
		GoogleFetch Link = new GoogleFetch();
		finalLink = Link.Message(e);
		
		MessageEmbed Qembed = null;
		Document doc2 = null;
		try {
			doc2 = Jsoup.connect(finalLink).get();
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		//Question Content
		String Qcontent = null;
		try{
		Elements QcontentDig = doc2.select("div#mainbar div#question");
		Element QcontentF = QcontentDig.select("td.postcell div.post-text").first();
		Qcontent = QcontentF.text();
		//System.out.println(content);
		}catch(Exception ex){
		
		}
		
		EmbedBuilder eb = new EmbedBuilder();	
			eb.setTitle(":question:" + "Question");
			eb.setDescription(Qcontent);
			Qembed = eb.build();
			
		return Qembed;
	}
	
	public MessageEmbed Answer(MessageReceivedEvent e){
		String finalLink = "";
		
		GoogleFetch Link = new GoogleFetch();
		finalLink = Link.Message(e);		
		
		MessageEmbed Aembed = null;
		Document doc2 = null;
		try {
			doc2 = Jsoup.connect(finalLink).get();
		
		} catch (Exception ex) {
			System.out.println("Error at codeSearch, while connecting to finalLink");
			ex.printStackTrace();
		}
		
		//Title
		String Title ="Answer";
		String Status = "";
		//Answer Content
		String content = null;
		try{
		Elements contentDig = doc2.select("div#mainbar div#answers");
		Element contentF = contentDig.select("div.accepted-answer td.answercell div.post-text").first();
		content = contentF.text();
		//Status icon
		Status = ":white_check_mark:";
		
		}catch(Exception ex){
			try{
			Elements AcontentDig = doc2.select("div#mainbar div#answers");
			Element AcontentF = AcontentDig.select("div.answer td.answercell div.post-text").first();
			content = AcontentF.text();
			//System.out.println(content);
			//Side image
			Status = ":x:";
			}catch(Exception ex2){
				Elements AcontentDig = doc2.select("div.mw-content-text");
				Element AcontentFirst = AcontentDig.select("p:contains()").first();
					content = AcontentFirst.text();
			}
			System.out.println(Status + "\n" + content);
			EmbedBuilder eb = new EmbedBuilder();    					
				eb.setTitle(Status + Title);
				eb.setDescription(content + "\n\n**More at: **" + finalLink);
				Aembed = eb.build();
		}
		
		EmbedBuilder eb = new EmbedBuilder();    					
			eb.setTitle(Status + Title);
			eb.setDescription(content + "\n\n**More at: **" + finalLink);
			Aembed = eb.build();
		
	return Aembed;
	}
	
}
