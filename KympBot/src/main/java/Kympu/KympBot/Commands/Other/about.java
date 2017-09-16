package Kympu.KympBot.Commands.Other;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class about {
	public MessageEmbed Message(MessageReceivedEvent e){
		MessageEmbed embed = null;
		
		EmbedBuilder eb = new EmbedBuilder();
		String KympBotIcon = "https://secure.runescape.com/m=avatar-rs/default_chat.png?";
		String Message = "Created by Kympu on 15th of july, 2017 Currently running in Java."
				+ "\n\nTo access command list type !help";

		eb.setTitle("About KympBot");
		eb.setDescription(Message);
		eb.setThumbnail(KympBotIcon);
		embed = eb.build();
		
		return embed;
	}
}
