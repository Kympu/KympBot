package Kympu.KympBot.Commands.Other;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class findLink {
	public String Message(MessageReceivedEvent e){
		
		GoogleFetch Link = new GoogleFetch();
		String finalLink = Link.Message(e);		
		
		return finalLink;
	}
}
