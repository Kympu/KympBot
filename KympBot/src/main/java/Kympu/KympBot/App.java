package Kympu.KympBot;
//https://discordapp.com/oauth2/authorize?client_id=335464966255542272&scope=bot&permissions=0

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginException;
import javax.swing.ImageIcon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.Commands.Help;
import Kympu.KympBot.Commands.MonsterWarlord.Events;
import Kympu.KympBot.Commands.MonsterWarlord.Info;
import Kympu.KympBot.Commands.MonsterWarlord.mwlist;
import Kympu.KympBot.Commands.MonsterWarlord.mwsearch;
import Kympu.KympBot.Commands.Other.GoogleFetch;
import Kympu.KympBot.Commands.Other.about;
import Kympu.KympBot.Commands.Other.ask;
import Kympu.KympBot.Commands.Other.codeSearch;
import Kympu.KympBot.Commands.Other.findLink;
import Kympu.KympBot.Commands.Other.gameSearch;
import Kympu.KympBot.Commands.Other.imageSearch;
import Kympu.KympBot.Commands.Other.price;
import Kympu.KympBot.Commands.Other.twitch;
import Kympu.KympBot.Commands.Other.urban;
import Kympu.KympBot.Commands.Other.weather;
import Kympu.KympBot.Commands.Other.wiki;
import Kympu.KympBot.Commands.Other.youTube;
import Kympu.KympBot.Commands.RuneScape.GEprice;
import Kympu.KympBot.Commands.RuneScape.Quest;
import Kympu.KympBot.Commands.RuneScape.Slayer;
import Kympu.KympBot.Commands.RuneScape.accLookup;
import Kympu.KympBot.Commands.RuneScape.itemSearch;
import Kympu.KympBot.Commands.RuneScape.rsWiki;
import Kympu.KympBot.Commands.RuneScape.rslist;
import Kympu.KympBot.Console.report;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Icon;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.EmbedBuilder;

public class App extends ListenerAdapter{
	 public static String filename = "C:/Users/Eric/Desktop/MW/TextFiles/Tips.txt";
	 public static void main( String[] args ) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException{
	        JDA jdaBot = new JDABuilder(AccountType.BOT).setToken("MzM1NDY0OTY2MjU1NTQyMjcy.DEqJsg.23sko4HUm9FVvPbV65GoeTuo-J8").buildBlocking();
	        jdaBot.setAutoReconnect(true);
	        jdaBot.addEventListener(new App());
	    }

	 
	 	public void Report(MessageReceivedEvent e){
	 		report SendReport = new report();
			System.out.println(SendReport.Report(e));
	 	}
	 	
	    public void onMessageReceived(MessageReceivedEvent e){
	    	  	
	    	Message objMsg = e.getMessage();
	    	MessageChannel objChannel = e.getChannel();
	    	User objUser = e.getAuthor();
	    	
		    	if((objMsg.getContent().equalsIgnoreCase("@exit!"))  
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
		    		System.exit(0);
		    	}
		    	
		    	if((objMsg.getContent().toLowerCase().equals("!List") || objMsg.getContent().toLowerCase().equals("!help"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    				Report(e);
	    			
		    			Help Send = new Help();
		    			objChannel.sendMessage(Send.Message()).queue();    					
		    					
		    	}
		    	
		    	if((objMsg.getContent().equalsIgnoreCase("!Mwlist"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	
		    			Report(e);
	    			
		    			mwlist Send = new mwlist();
		    			objChannel.sendMessage(Send.Message()).queue(); 
		    		
		             }
		    	
		    	if((objMsg.getContent().equalsIgnoreCase("!RSlist"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
		    		rslist Send = new rslist();
		    		objChannel.sendMessage(Send.Message()).queue();
		    		
		             }
		    	
		    	if((objMsg.getContent().equalsIgnoreCase("!eForum")) 
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){    		
		    			objChannel.sendMessage("https://m.gamevilusa.com/forums/forumdisplay.php?1506-Events").queue();
		    	}	    		    	
		    	
		    	if((objMsg.getContent().toLowerCase().contains("lol")  
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId())){
		    		objChannel.sendMessage("Haha!").queue();
		    	}
		    	
		    	if((objMsg.getContent().equalsIgnoreCase("!Event"))  
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

		    			Report(e);
	    			
		    			Events Send = new Events();
		    			objChannel.sendMessage(Send.Message()).queue();
				
					}
		    	    
		    	if((objMsg.getContent().toLowerCase().startsWith("!info"))  
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			   	
					Info Send = new Info();					
					objChannel.sendMessage(Send.Message(e)).queue();
					
		    	} 
		    	
		    	if((objMsg.getContent().equalsIgnoreCase("!date"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
		    		Date today = new Date();
		            DateFormat df = new SimpleDateFormat("MM-dd-yy h:mm a");	          
		            df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles")); 	     //dispalying date on PST timezone
		            String PST = df.format(today);
		    		
		    		objChannel.sendMessage("```" + PST + " in Monster Warlord world!```").queue();
	  		
		    	}  
		
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!mwsearch")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			mwsearch Send = new mwsearch();					
					objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!wiki"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			searchType = "english+Wikipedia";
	    			
	    			wiki Send = new wiki();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!youtube") || objMsg.getContent().toLowerCase().startsWith("!yt")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			youTube Send = new youTube();                    
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!urban "))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			urban Send =  new urban();
	    			objChannel.sendMessage(Send.Message(e)).complete();
	    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!twitch"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			searchType = "twitch";
	    			
	    			twitch Send =  new twitch();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!game")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			gameSearch Send = new gameSearch();
	    			objChannel.sendMessage(Send.Message(e)).queue();
		    	
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!ask")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			ask Send = new ask();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
		    	} 	    		
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!image "))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    				Report(e);
	    			
	    				imageSearch Send = new imageSearch();
		    			objChannel.sendMessage(Send.Message(e)).queue();		    			
	    			
		    	}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("fuck off")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			objChannel.sendMessage("Sorry! :(").complete();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().contains("!fuck you")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			objChannel.sendMessage("No, fuck you").complete();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!price") || objMsg.getContent().toLowerCase().startsWith("!pr")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			searchType = "runescape3";
	    			
	    			GEprice Send = new GEprice();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!quest")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			searchType = "Runescape3+quest";
	    			
	    			Quest Send = new Quest();		
	    			objChannel.sendMessage(Send.Message(e)).queue();
		
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!item")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			searchType = "Runescape3+item";
	    			
	    			itemSearch Send = new itemSearch();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!slayer")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    			
	    			searchType = "Runescape3+slayer";
	    			
	    			Slayer Send = new Slayer();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!acc"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){

	    			Report(e);
	    				
	    			accLookup Send = new accLookup();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!about")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){ 

	    			Report(e);
	    			
	    			about Send = new about();
	    			objChannel.sendMessage(Send.Message(e)).complete();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!rswiki") || objMsg.getContent().toLowerCase().startsWith("!rsw")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){ 
	    			
	    			Report(e);
	    			
	    			searchType = "Runescape3+wiki";
	    			
	    			rsWiki Send = new rsWiki();
	    			objChannel.sendMessage(Send.Message(e)).complete();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!weather")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){ 
	    			
	    			Report(e);
	    			
	    			weather Send = new weather();
	    			objChannel.sendMessage(Send.Message(e)).complete();
	    			
	    		}   		
	    		
	    		if((objMsg.getContent().equalsIgnoreCase("!eric"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			Report(e);
	    			
	    			Message message = new MessageBuilder().append("This is how Eric looks like").build();
	    			try {
						objChannel.sendFile(new File("C:/Users/Eric/Desktop/KympBot/src/main/java/Kympu/KympBot/Images/Eric2.png"), message).queue();
					} catch (IOException e1) {
						objChannel.sendMessage("Error").complete();
					}
    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!find"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			Report(e);
	    			
		    		findLink Send = new findLink();
		    		objChannel.sendMessage(Send.Message(e)).complete();
		    		
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!buy") || objMsg.getContent().toLowerCase().startsWith("!ali")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			Report(e);
	    			
	    			searchType = "aliexpress";
	    			
	    			price Send = new price();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!code ") || objMsg.getContent().toLowerCase().startsWith("$")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			Report(e);
	    			
	    			searchType = "stackoverflow";
	    			
	    			codeSearch Content = new codeSearch();
	    			objChannel.sendMessage(Content.Question(e)).queue();
	    			objChannel.sendMessage(Content.Answer(e)).queue();
	    			
	    		}
	    		
	    		
    }
	    
	private static String searchType;
	public static String Pass(){
		return searchType;
	}
}
