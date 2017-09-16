package Kympu.KympBot.Console;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class report {
	
	static String passToConsole = "";
	
	public String Report(MessageReceivedEvent e){
		String report = "";
		Message objMsg = e.getMessage();
		String Message = objMsg.getContent();
		
		//Getting user
		User getUser = e.getAuthor();
		String getUserID = e.getAuthor().getAsMention();
		String User = getUser.toString();
			User = User.replace("(","").replace(")","").replace("U:", "");
			getUserID = getUserID
					.replaceAll("<", "(")
					.replaceAll("@", "")
					.replaceAll(">", ")");
			User = User.replaceAll(getUserID, "");
		
		//Getting the time of command
		Date Current = new Date();
	    DateFormat df = new SimpleDateFormat("[hh:mm:ss]");//MM-dd-yy h:mm a
		String sysTime = df.format(Current);
		
		//Getting the command name	
		String Command = Message.split(" ")[0];
		
		//Getting the message
		String msgInput = Message.toString().replace(Command + " ", "");
		
		report = sysTime +  " [" + User + "]" + " [" + Command + "] " + "Input: " + msgInput;
		
	return report;
	}
}
