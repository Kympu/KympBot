package Kympu.KympBot.Commands;

public class Help {
	public String Message(){
		
		String Message = "```~List of Bot commands~\n"
				+ "\n!Wiki <sentence>    - Wikipedia search"
				+ "\n!Youtube <sentence> - Youtube video search"
				+ "\n   !Youtube #playlist for video playlist search"
				+ "\n   !Youtube #new for vidoes posted within 7 days"
				+ "\n!Urban <sentence>   - Urban Dictionary Search"
				+ "\n!Twitch <name>      - Streamer search"
				+ "\n!Ask <question>     - Ask a YES or a NO question!"
				+ "\n!Game <name>	    - Search for an existing game"
				+ "\n!Image <name>       - Image search"
				+ "\n\n~Other game Bot commands~\n"
				+ "\n!MWlist - MW information serach"
				+ "\n!RSlist - Runescape info search```";
		
		return Message;
	}
}
