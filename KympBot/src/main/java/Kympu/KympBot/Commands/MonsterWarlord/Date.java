package Kympu.KympBot.Commands.MonsterWarlord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Date {
	public String Message(){
		
		Date today = new Date();
        DateFormat df = new SimpleDateFormat("MM-dd-yy h:mm a");	          
        df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles")); 	     //dispalying date on PST timezone
        String PST = df.format(today);
		
		String Message = "```" + PST + " in Monster Warlord world!```";		
		return Message;	
	}	
}
