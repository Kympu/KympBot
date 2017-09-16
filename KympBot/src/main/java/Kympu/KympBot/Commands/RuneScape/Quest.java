package Kympu.KympBot.Commands.RuneScape;

import Kympu.KympBot.Commands.Other.GoogleFetch;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Quest {
	public String Message(MessageReceivedEvent e){
	
		GoogleFetch Link = new GoogleFetch();
		String finalLink = Link.Message(e);		
		
		return finalLink;
	}
}
