package Kympu.KympBot.Commands.RuneScape;

public class rslist {
	public String Message(){
		
		String Message = "```~List of Runescape commands~\n"
				+ "\n!price <item>    - Item price info"
				+ "\n!quest <name>    - quest search"
				+ "\n!slayer <name>   - slayer monster search"
				+ "\n!item <name>     - item search"
				+ "\n!rsw <title	  - RS topic search>```";
		
		return Message;
	}
}
