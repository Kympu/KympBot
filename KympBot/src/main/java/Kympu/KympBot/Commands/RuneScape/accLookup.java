package Kympu.KympBot.Commands.RuneScape;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class accLookup {
	public String Message(MessageReceivedEvent e){
		
		MessageEmbed embed = null;
		Message objMsg = e.getMessage();
		String RuneClan = "http://www.runeclan.com/user/";
		String Name = objMsg.getContent().toString()
				.replaceAll("!acc ", "")
				.replaceAll(" ", "+");
		String Lookup = RuneClan + Name;
		
		Document site = null;
		try {
			site = Jsoup.connect(Lookup).get();
		} catch (IOException ex) {
			EmbedBuilder eb = new EmbedBuilder();
				eb.setTitle("Error occured");
				eb.setDescription("No Info Found!");
				embed = eb.build();
			System.err.println("Error while trying to connect to:" + site);
		}
		Elements Context = site.select("div.wrapper div.box_content table tr");
		Elements usernameDig = site.select("div.xp_tracker_hleft span.xp_tracker_hname");
		String Username = usernameDig.text();
		String Skill = "", Skill2 = "";
		String Level = "",  XP = "", Rank = "";
		
		for(Element tr : Context){
			Elements Skills = tr.select("td.xp_tracker_skill");
			
			Elements Levels = tr.select("td.xp_tracker_lvl");
			Elements XPs = tr.select("td.xp_tracker_cxp");
			Elements Ranks = tr.select("td.xp_tracker_rsrank");
			Skill = Skills.text();
			Level = Levels.text();
			XP = XPs.text();
			Rank = Ranks.text();
			Skill2 += Skill + "\t" + Level + "\t" + Rank + "\t" + XP + "\n";
		
	}
		String Message = "```Username: " + Username + "\n\nSkill\tLevel\tRank\tXP" + Skill2 + "```";				  
		
		return Message;
	}
}
