package Kympu.KympBot.Commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Sample {
	public String Message(){
		
		String Message = "EnterWhatever";
		
		return Message;
	}
}

/* In Main class
Sample sampleObject = new Sample();
sampleObject.Message();
objChannel.sendMessage(sampleObject.Message()).complete(); 
*/


/*

public String Message(MessageReceivedEvent e){		
 
	Message objMsg = e.getMessage();
}
*/