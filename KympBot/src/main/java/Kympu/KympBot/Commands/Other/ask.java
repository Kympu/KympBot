package Kympu.KympBot.Commands.Other;

import java.util.Random;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ask {
	public String Message(MessageReceivedEvent e){
		
		Random rnd = new Random();
		int random = rnd.nextInt(21) + 1;
		String FirstPart = "";
		switch(random){
		
		case 1: FirstPart = ("It is certain");
			break;
		
		case 2: FirstPart = (" It is decidedly so");
			break;
		
		case 3: FirstPart = ("Without a doubt");
			break;
		
		case 4: FirstPart = ("Yes definitely");
			break;
		
		case 5: FirstPart = ("You may rely on it");
			break;
			
		case 6: FirstPart = ("As I see it, yes");
			break;
			
		case 7: FirstPart = ("Most likely");
			break;
			
		case 8: FirstPart = ("Outlook good");
			break;
			
		case 9: FirstPart = ("Yes");
			break;
			
		case 10: FirstPart = ("Signs point to yes");
			break;
			
		case 11: FirstPart = (" Reply hazy try again");
			break;
			
		case 12: FirstPart = ("Ask again later");
			break;
			
		case 13: FirstPart = ("Better not tell you now");
			break;
			
		case 14: FirstPart = ("Cannot predict now");
			break;
			
		case 15: FirstPart = ("Concentrate and ask again");
			break;
			
		case 16: FirstPart = ("Don't count on it");
			break;
			
		case 17: FirstPart = ("My reply is no");
			break;
			
		case 18: FirstPart = ("My sources say no");
			break;
			
		case 19: FirstPart = ("Outlook not so good");
			break;
			
		case 20: FirstPart = ("Very doubtful");
			break;
			
		case 21: FirstPart = ("Fuck you");
			break;
			
		case 22: FirstPart = ("Y- No");
			break;
		
		case 23: FirstPart = ("I dont think so");
			break;
		
		case 24: FirstPart = ("Im not going to answer");
			break;
		
		case 25: FirstPart = ("Nope");
			break;
		
		}
		
		String Emoji = ":thinking: | "; 			    	
		String Send = Emoji + FirstPart + ".";
		return Send;
	}
}
