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
import Kympu.KympBot.Commands.Other.ask;
import Kympu.KympBot.Commands.Other.gameSearch;
import Kympu.KympBot.Commands.Other.imageSearch;
import Kympu.KympBot.Commands.Other.twitch;
import Kympu.KympBot.Commands.Other.urban;
import Kympu.KympBot.Commands.Other.wiki;
import Kympu.KympBot.Commands.Other.youTube;
import Kympu.KympBot.Commands.RuneScape.rslist;
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
	    			
	    			Help Send = new Help();
	    			objChannel.sendMessage(Send.Message()).queue();    					
	    					
	    	}
	    	
	    	if((objMsg.getContent().equalsIgnoreCase("!Mwlist"))
	    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    	    
	    			mwlist Send = new mwlist();
	    			objChannel.sendMessage(Send.Message()).queue(); 
	    		
	             }
	    	
	    	if((objMsg.getContent().equalsIgnoreCase("!RSlist"))
	    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    	    
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
	    		
	    			Events Send = new Events();
	    			objChannel.sendMessage(Send.Message()).queue();
			
				}
	    	    
	    	if((objMsg.getContent().toLowerCase().startsWith("!info"))  
	    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    		    	
				Info Send = new Info();					
				objChannel.sendMessage(Send.Message(e)).queue();
				
	    	} 
	    	
	    	if((objMsg.getContent().equalsIgnoreCase("!date"))
	    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
   
	    		Date today = new Date();
	            DateFormat df = new SimpleDateFormat("MM-dd-yy h:mm a");	          
	            df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles")); 	     //dispalying date on PST timezone
	            String PST = df.format(today);
	    		
	    		objChannel.sendMessage("```" + PST + " in Monster Warlord world!```").queue();
  		
	    	}  
		
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!mwsearch")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			mwsearch Send = new mwsearch();					
					objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!wiki"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			searchType = "english+Wikipedia";
	    			
	    			wiki Send = new wiki();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!youtube") || objMsg.getContent().toLowerCase().startsWith("!yt")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			youTube Send = new youTube();                    
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!urban "))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			urban Send =  new urban();
	    			objChannel.sendMessage(Send.Message(e)).complete();
	    			
	    	}
	    	
	    		 /////////////////////////////////////////////////
	    		//////////////////Twitch Search//////////////////
	    	   /////////////////////////////////////////////////
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!twitch"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			searchType = "twitch";
	    			
	    			twitch Send =  new twitch();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!game")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			gameSearch Send = new gameSearch();
	    			objChannel.sendMessage(Send.Message(e)).queue();
		    	}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!ask")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			ask Send = new ask();
	    			objChannel.sendMessage(Send.Message(e)).queue();
	    			
		    	} 	    		
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!image "))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    				imageSearch Send = new imageSearch();
		    			objChannel.sendMessage(Send.Message(e)).queue();		    			
	    			
		    		}	  
	    		
	    		////////////////////////////////////////////////
	    	   //////////////////Patch Search//////////////////
	    	  ////////////////////////////////////////////////
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!patch")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			Document site = null;
	    			
	    			try{ 
	    				site = Jsoup.connect("http://na.leagueoflegends.com/en/news/game-updates/patch").get(); 
	    				}
	    			catch (IOException e1){ 

	    				System.err.print("\nError while trying to connect to:" + site);
	    				}
	    			
	    			Elements urlDig = site.select("div.section-wrapper div.section-wrapper-content div.content-border div.white-stone");
	    			Element link = urlDig.select("a").first();
	    			String linkRedirect = link.attr("abs:href");

	    				Document newSite = null;
	    				try {
	    					newSite = Jsoup.connect(linkRedirect).get();			
	    				} catch (IOException ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				Elements Title = newSite.select("div.section-wrapper div.section-wrapper-content-wrapper div.content-border");
	    				Elements urlDig2 = newSite.select("div.section-wrapper div.section-wrapper-content-wrapper div#patch-notes-container "
	    						+ "blockquote");
	    				Element firstp = urlDig2.first();
	    				String FPa = firstp.toString().replaceAll("<.*?>", "");
	    				String FPar = Jsoup.parse(FPa).text();
	    				
	    				//System.out.print(FPa);
	    				objChannel.sendMessage("```" + FPa + "```" + "\n" + linkRedirect).complete();	    		
	    		}
	    		if(objMsg.getContent().toLowerCase().startsWith("fuck off")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			objChannel.sendMessage("Sorry! :(").complete();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().contains("!fuck you")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			objChannel.sendMessage("No, fuck you").complete();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!price") || objMsg.getContent().toLowerCase().startsWith("$")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			String finalLink = "";
	    			String Message = objMsg.getContent();
	    			String Search = Message.toString().toLowerCase()
	    					.replaceAll("!price", "")
	    					.replaceAll("$", "")
	    					.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.lv/search?q=runescape+";	    			
	    			String GoogleSearch = GoogleLink + Search;
	    			Document doc = null;
	    			try{	
	    				try {
	    					doc = Jsoup.connect(GoogleSearch).get();
	    				} catch (Exception ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				Elements urlDig = doc.select("div#rcnt");
	    				Elements urlDig2 = urlDig.select("div#center_col");								
	    				for(Element context : urlDig2){																				
	    					String search = "wiki";								
	    					Element link = doc.select("div.med div._NId h3 a:contains("+ search + ")").first();
	    					finalLink = link.attr("abs:href");
	    					if(finalLink.contains("https://en.wikipedia.org/wiki/%")){
	    						objChannel.sendMessage("No information found!").complete();
	    						break;						
	    					}
	    					//System.out.print(finalLink + "\n");				
	    				}
	    				Document doc2 = null;
	    				try{	
	    					try {
	    						doc2 = Jsoup.connect(finalLink).get();
	    					} catch (Exception ex) {
	    						
	    						ex.printStackTrace();
	    					}
	    					
	    					//Title
	    					Elements TitleDig = doc2.select("div.WikiaPageContentWrapper h1");
	    					String Title = TitleDig.text();
	    					
	    					//Image
	    					Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
	    					Element imageFirst = imageDig.select("a").first();
	    					String imageUrl = imageFirst.attr("abs:href");		
	    					
	    					//GE price
	    					Elements urlDigW = doc2.select("div.infobox-wrapper tr span.infobox-quantity span");
	    					String urlDigW2 = urlDigW.text();
	    					
	    					//High ALch
	    					String HighAlch = "";

	    					Elements HighAlchDig = doc2.select("div.infobox-wrapper tr:contains(high) td");
	    					HighAlch = HighAlchDig.text(); 
	    					if(HighAlch == null){
	    						HighAlch = "Cannot Alch";
	    					}
	    					
	    					//Price Change
	    					Elements infoDig = doc2.select("div.infobox-wrapper tr span.infobox-quantity a");
	    					Element infoLink = infoDig.select("a[href]").first();
	    					String infoLink2 = infoLink.attr("abs:href");
	    						Document doc3 = null;
	    						doc3 = Jsoup.connect(infoLink2).get();
	    						Elements GELink = doc3.select("div.WikiaSiteWrapper section#WikiaPage div.WikiaPageContentWrapper "
	    								+ "article#WikiaMainContent table.wikitable tbody tr td ul li a:contains(Look up current price)");
	    						Element GELink2 = GELink.select("a[href]").first();
	    						String GEfinalLink = GELink2.attr("abs:href");
	    							Document doc4 = null;
	    							doc4 = Jsoup.connect(GEfinalLink).get();
	    							Elements prChange = doc4.select("li:contains(Today) span span");
	    							String todayChange = prChange.text();
	    					
	    							String Symbol = "";
	    							if(todayChange.startsWith("-")){
	    								Symbol = ":chart_with_downwards_trend:";
	    							}
	    							else{
	    								Symbol = ":chart_with_upwards_trend:";
	    							}
	    							String SymbolM = "";
	    							Elements prMChange = doc4.select("li:contains(1 Month) span span");
	    							String monthChange = prMChange.text();
	    								if(monthChange.startsWith("-")){
	    									SymbolM = ":chart_with_downwards_trend:";
	    								}
	    								else{
	    									SymbolM = ":chart_with_upwards_trend:";
	    								}
	    								
	    								EmbedBuilder eb = new EmbedBuilder();
	    								
	    				    			String endContent = "**" + Title + ": **" + urlDigW2 + " coins" 
	    	    								+ "\n" + Symbol + "**Today's Change: **" + todayChange
	    	    								+ "\n" + SymbolM + "**1 Month Change: **" + monthChange
	    	    								+ "\n**High Alch: **" + HighAlch;
	    				    			
	    								eb.setDescription(endContent);
	    				    			eb.setThumbnail(imageUrl);
	    				    			MessageEmbed embed = eb.build();
	    					objChannel.sendMessage(embed).complete();
	    					
	    					
	    				}
	    					
	    				catch(Exception ex){
	    					objChannel.sendMessage("No information found!").complete();
	    				}
	    				
	    			}
	    			catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}
	    			
	    		}
	    		
	    		///////////////////////////////////////////////
	    	   //////////////TESTING SLOTS////////////////////
	    	  ///////////////////////////////////////////////
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!bs")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			Random rnd = new Random();
					int random = rnd.nextInt(10) + 1;
					String FirstPart = "";
					
					int smth[] = new int[9];
					
					for(int i = 0; i <= 9; i++){
						smth[i] = rnd.nextInt(10) + 1;
					}
					
					//System.out.print();
					
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!quest")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    		
	    			String Message = objMsg.getContent();
		    		String Search = Message.toString()
		    				.replaceAll("!quest ", "")
		    				.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.lv/search?q=runescape+3+";	    			
	    			String GoogleSearch = GoogleLink + Search;		
	    			//System.out.println(GoogleSearch);	
	    				Document doc = null;
	    			try{	
	    				try {
	    					doc = Jsoup.connect(GoogleSearch).get();
	    				} catch (Exception ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				Elements urlDig = doc.select("div#rcnt");
	    				Elements urlDig2 = urlDig.select("div#center_col");								
	    				for(Element context : urlDig2){																				
	    					String search = "wiki";								
	    					Element link = doc.select("div.med div._NId h3 a:contains("+ search + ")").first();
	    					String finalLink = link.attr("abs:href");
	    					if(finalLink.contains("https://en.wikipedia.org/wiki/%")){
	    						objChannel.sendMessage("No information found!").complete();
	    						break;						
	    					}
	    					objChannel.sendMessage(finalLink).complete();
	    					//String QuickGuide = finalLink + "/Quick_guide";
	    					
	    					
	    					
	    					
	    				}
	    			}
	    			catch(Exception ex){
	    				//objChannel.sendMessage("No information found!").complete();
	    			}	 
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!item")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			String finalLink = "";
	    			String Message = objMsg.getContent();
	    			String Search = Message.toString().toLowerCase()
	    					.replaceAll("!price", "")
	    					.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.lv/search?q=runescape+";	    			
	    			String GoogleSearch = GoogleLink + Search;
	    			Document doc = null;
	    			try{	
	    				try {
	    					doc = Jsoup.connect(GoogleSearch).get();
	    				} catch (Exception ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				Elements urlDig = doc.select("div#rcnt");
	    				Elements urlDig2 = urlDig.select("div#center_col");								
	    				for(Element context : urlDig2){																				
	    					String search = "wiki";								
	    					Element link = doc.select("div.med div._NId h3 a:contains("+ search + ")").first();
	    					finalLink = link.attr("abs:href");
	    					if(finalLink.contains("https://en.wikipedia.org/wiki/%")){
	    						objChannel.sendMessage("No information found!").complete();
	    						break;						
	    					}
	    					Document doc2 = null;
	    					doc2 = Jsoup.connect(finalLink).get();
	    					
	    					//Title
	    					Elements TitleDig = doc2.select("div.WikiaPageContentWrapper h1");
	    					String Title = TitleDig.text();
	    					
	    					//Image
	    					Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
	    					Element imageFirst = imageDig.select("a").first();
	    					String imageUrl = imageFirst.attr("abs:href");
	    					
	    					//Content
	    					Elements contentDig = doc2.select("div.WikiaPageContentWrapper div.mw-content-text");
	    					Element contentFirst = contentDig.select("div.floatleft + p").first();
	    					String Content = contentFirst.text();
	    					
	    					EmbedBuilder eb = new EmbedBuilder();
	    					eb.setTitle(Title);
							eb.setDescription(Content);
			    			eb.setThumbnail(imageUrl);
			    			MessageEmbed embed = eb.build();
			    			objChannel.sendMessage(embed).complete();
	    				}
	    				Document doc2 = null;
	    				try{	
	    					try {
	    						doc2 = Jsoup.connect(finalLink).get();
	    					} catch (Exception ex) {
	    						
	    						ex.printStackTrace();
	    					}
	    					Elements urlDigW = doc2.select("div.infobox-wrapper tr span.infobox-quantity");
	    					String urlDigW2 = urlDigW.text();
	    					urlDigW2 = urlDigW2.replaceAll("(info)", "G.E. Price");
	    					//objChannel.sendMessage(urlDigW2).complete();
	    				}
	    					
	    				catch(Exception ex){
	    					objChannel.sendMessage("No information found!").complete();
	    				}
	    				
	    			}
	    			catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!slayer")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			String finalLink = "";
	    			String Message = objMsg.getContent();
	    			String Search = Message.toString().toLowerCase()
	    					.replaceAll("!slayer ", "")
	    					.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.lv/search?q=runescape+3+slayer+";	    			
	    			String GoogleSearch = GoogleLink + Search;
	    			Document doc = null;
	    			try{	
	    				try {
	    					doc = Jsoup.connect(GoogleSearch).get();
	    				} catch (Exception ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				Elements urlDig = doc.select("div#rcnt");
	    				Elements urlDig2 = urlDig.select("div#center_col");								
	    				for(Element context : urlDig2){																				
	    					String search = "wiki";								
	    					Element link = doc.select("div.med div._NId div.rc h3.r a:contains("+ search + ")").first();
	    					finalLink = link.attr("abs:href");
	    					if(finalLink.contains("https://en.wikipedia.org/wiki/%")){
	    						objChannel.sendMessage("No information found!").complete();
	    						break;						
	    					}
	    					//System.out.print(finalLink + "\n");	
	    					//objChannel.sendMessage(finalLink).complete();
	    				}
	    				Document doc2 = null;
	    				try{	
	    					try {
	    						doc2 = Jsoup.connect(finalLink).get();
	    					} catch (Exception ex) {
	    						
	    						ex.printStackTrace();
	    					}
	    					Elements urlDigW = doc2.select("div.mw-content-text h2:contains(Location) + ul li");
	    				
	    					//Title
	    					Elements titleDig = doc2.select("div.infobox-wrapper table caption");
	    					String Title = titleDig.text();
	    					
	    					//Image
	    					Elements imgDig = doc2.select("div.infobox-wrapper table tbody tr td");
	    					Element imgLink = imgDig.select("a").first();
	    					String imgUrl = imgLink.attr("abs:href");
	    					
	    					//XP
	    					Elements xpDig = doc2.select("div.infobox-wrapper table tbody tr");
	    						//Combat XP
	    					Element cmbXPDig = xpDig.select("td.mob-cb-xp").first();
	    					String cmbXP = cmbXPDig.text();
	    						//HP XP
	    					Element hpXPDig = xpDig.select("td.mob-hp-xp").first();
	    					String hpXP = hpXPDig.text();
	    						//Slayer XP
	    					Element slayXPDig = xpDig.select("td.mob-slay-xp").first();
	    					String slayXP = slayXPDig.text();
	    					
	    					//Content
	    					Elements contentDig = doc2.select("div.WikiaPageContentWrapper div.mw-content-text");
	    					Element contentFirst = contentDig.select("div.floatleft + p").first();
	    					String Content2 = contentFirst.text();
	    					
	    					//Weakness
	    					Elements weakDig = doc2.select("div.infobox-wrapper table tbody tr:contains(weakness) + tr td + td + td");
	    					Element Redir = weakDig.select("a[href]").first();
	    					String Red = Redir.attr("abs:href");
	    					Document WeakRed = null;
	    					WeakRed = Jsoup.connect(Red).get();
	    					Elements weaknDig = WeakRed.select("div.WikiaPageContentWrapper h1");
	    					String Weakness = weaknDig.text();
	    					Weakness = Weakness.replaceAll(" Fan Feed", "");
	    					if(Weakness.contains("Weakness")){
	    						Weakness = "No Weakness";
	    					}
	    					//System.out.print(Weakness);
	    					
	    					//Locations http://runescape.wikia.com/wiki/Slayer_monsters
	    					doc2 = Jsoup.connect("http://runescape.wikia.com/wiki/Slayer_monsters").get();
	    					Elements locDig = doc2.select("div.mw-content-text h2:contains(Location) + h3");
	    					String Location = "", Send = "";
	    					int i = 0;
	    					for(Element li : locDig){
	    						i++;
	    						Element Locat = li.select("span").first();
	    						Location += i + ". " + Locat.text() + "\n";
	    						
	    					}
	    					
	    					String Content = "**Combat XP:** " + cmbXP + "\n**Constitution XP:** " + hpXP
	    							+ "\n**Slayer XP:** " + slayXP + "\n**Weakness: **" + Weakness + "\n\n" + Content2;
	    					EmbedBuilder eb = new EmbedBuilder();
	    					eb.setTitle(Title);
							eb.setDescription(Content);
			    			eb.setThumbnail(imgUrl);
			    			MessageEmbed embed = eb.build();
			    			objChannel.sendMessage(embed).complete();
	    				}
	    					
	    				catch(Exception ex){
	    					objChannel.sendMessage("No information found!").complete();
	    				}
	    				
	    			}
	    			catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}
	    			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!acc"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
		    	    	
	    			String RuneClan = "http://www.runeclan.com/user/";
	    			String Name = objMsg.getContent().toString()
	    					.replaceAll("!acc ", "")
	    					.replaceAll(" ", "+");
	    			String Lookup = RuneClan + Name;
	    			
	    			Document site = null;
	    			try {
	    				site = Jsoup.connect(Lookup).get();
	    			} catch (IOException ex) {
	    				objChannel.sendMessage("Error while obtaining forum page!").complete();
	    				System.err.println("Error while trying to connect to:" + site);
	    			}
	    			Elements Context = site.select("div.wrapper div.box_content table tr");
	    			Elements usernameDig = site.select("div.xp_tracker_hleft span.xp_tracker_hname");
	    			String Username = usernameDig.text();
	    			String Skill = "", Skill2 = "";
	    			String Level = "",  XP = "", Rank = "";
	    			for(Element tr : Context){
	    				Elements Skills = tr.select("td.xp_tracker_skill");
	    				
	    				Elements Levels = tr.select("td.xp_tracker_lvl");
	    				Elements XPs = tr.select("td.xp_tracker_cxp");
	    				Elements Ranks = tr.select("td.xp_tracker_rsrank");
	    				Skill = Skills.text();
	    				Level = Levels.text();
	    				XP = XPs.text();
	    				Rank = Ranks.text();
	    				Skill2 += Skill + "\t" + Level + "\t" + Rank + "\t" + XP + "\n";
	    			
	    		}
	    			objChannel.sendMessage("```Username: " + Username + "\n\nSkill\tLevel\tRank\tXP" + Skill2 + "```").complete();				  
		        }
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!about")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){ 
	    			
	    			EmbedBuilder eb = new EmbedBuilder();
	    			String embedUrl = "https://secure.runescape.com/m=avatar-rs/default_chat.png?";
	    			String Message = "Created by Kympu on 15th of july, 2017 Currently running in Java";
	    			//eb.setImage(embedUrl);
	    			eb.setDescription(Message);
	    			eb.setTitle("Testing");
	    			eb.setThumbnail(embedUrl);
	    			MessageEmbed embed = eb.build();
	    			objChannel.sendMessage(embed).complete();
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!rswiki") || objMsg.getContent().toLowerCase().startsWith("!rsw")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){ 
	    			
	    			String finalLink = "";
	    			String Message = objMsg.getContent();
	    			String Search = Message.toString().toLowerCase()
	    					.replaceAll("!rswiki ", "")
	    					.replaceAll("!rsw ", "")
	    					.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.com/search?q=runescape+3+wiki+";	    			
	    			String GoogleSearch = GoogleLink + Search;
	    			Document doc = null;
	    			try{	
	    				try {
	    					doc = Jsoup.connect(GoogleSearch).get();
	    				} catch (Exception ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				Elements urlDig = doc.select("div#rcnt");
	    				Elements urlDig2 = urlDig.select("div#center_col");								
	    				for(Element context : urlDig2){																				
	    					String search = "wiki";								
	    					Element link = doc.select("div.med div._NId div.rc h3.r a:contains("+ search + ")").first();
	    					finalLink = link.attr("abs:href");
	    					if(finalLink.contains("https://en.wikipedia.org/wiki/%")){
	    						objChannel.sendMessage("No information found!").complete();
	    						break;						
	    					}
	    					//System.out.print(finalLink + "\n");	
	    					//objChannel.sendMessage(finalLink).complete();
	    				}
	    				Document doc2 = null;
	    				try{	
	    					try {
	    						doc2 = Jsoup.connect(finalLink).get();
	    					} catch (Exception ex) {
	    						
	    						ex.printStackTrace();
	    					}
	    				
	    					//Title
	    					Elements titleDig = doc2.select("div.WikiaPageContentWrapper h1");
	    					String Title = titleDig.text();
	    					Title = Title.replaceAll(" Fan Feed", "");
	    					//Image
	    					String imgUrl = "";
	    					Boolean imgT = true;
	    					try{
	    					Elements imgDig = doc2.select("div.infobox-wrapper table tbody tr td");
	    					Element imgLink = imgDig.select("a").first();
	    					imgUrl = imgLink.attr("abs:href");
	    					}catch(Exception ex){
	    						Elements imageDig = doc2.select("div.WikiaPageContentWrapper");
	    						Element imageFirst = imageDig.select("a[href].image").first();
	    						imgUrl = imageFirst.attr("abs:href");
	    					}
	    				
	    					//Content
	    					String content = null;
	    					try{
	    					Elements contentDig = doc2.select("div.WikiaMainContentContainer div.mw-content-text");
	    					Element contentF = contentDig.select("div.floatleft + p").first();
	    					content = contentF.text();
	    					}catch(Exception ex){
	    						Elements contentDig = doc2.select("div.mw-content-text");
	    						Element contentFirst = contentDig.select("p:contains(" + Title +")").first();
	    						content = contentFirst.text();
	    					}
	    					EmbedBuilder eb = new EmbedBuilder();
	    					
	    					//Side image
	    					String imageUrl2 = null;
	    					Boolean sideImage = true;
	    					try{
	    					Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
	    					Element imageFirst = imageDig.select("a").first();
	    					imageUrl2 = imageFirst.attr("abs:href");
	    					}catch(Exception ex){
	    						sideImage = false;
	    					}
	    					
	    					eb.setTitle(Title);
							eb.setDescription(content + "\n\n**More at: **" + finalLink);
							if(sideImage){
							eb.setThumbnail(imageUrl2);
							}
							if(imgT){
			    			eb.setImage(imgUrl);
							}
			    			MessageEmbed embed = eb.build();
			    			objChannel.sendMessage(embed).complete();
	    				}
	    					
	    				catch(Exception ex){
	    					objChannel.sendMessage("No information found!").complete();
	    				}
	    				
	    			}
	    			catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}
	    			
	    		}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!weather")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){ 
	    			
	    			String finalLink = "";
	    			String Message = objMsg.getContent();
	    			String Search = Message.toString().toLowerCase()
	    					.replaceAll("!wearher ", "")
	    					.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.com/search?";	    			
	    			String GoogleSearch = GoogleLink + Search;
	    			Document doc = null;
	    			try{	
	    				try {
	    					doc = Jsoup.connect(GoogleSearch).get();
	    				} catch (Exception ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				
	    				Document doc2 = doc;
	    				try{	
	    					try {
	    						doc2 = Jsoup.connect(finalLink).get();
	    					} catch (Exception ex) {
	    						
	    						ex.printStackTrace();
	    					}
	    					
	    					//Title
	    					Elements titleDig = doc2.select("div#wob_wc div#wob_loc");
	    					String Title = titleDig.text();
	    					
	    					//Image
	    					Elements imgDig = doc2.select("div.infobox-wrapper table tbody tr td");
	    					Element imgLink = imgDig.select("a").first();
	    					String imgUrl = imgLink.attr("abs:href");
	    					
	    					//Side image
	    					Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
	    					Element imageFirst = imageDig.select("a").first();
	    					String imageUrl2 = imageFirst.attr("abs:href");
	    					boolean go = true;
	    					if(imageUrl2 == null){
	    						go = false;
	    					}
	    					//Content
	    					Elements contentDig = doc2.select("div.WikiaPageContentWrapper div.mw-content-text");
	    					Element contentFirst = contentDig.select("div.floatleft + p").first();
	    					String Content = contentFirst.text();
	    					
	    					EmbedBuilder eb = new EmbedBuilder();
	    					eb.setTitle(Title);
							//eb.setDescription(Content);
			    			//eb.setImage(imgUrl);
			    			MessageEmbed embed = eb.build();
			    			objChannel.sendMessage(embed).complete();
	    				}
	    					
	    				catch(Exception ex){
	    					objChannel.sendMessage("No information found!").complete();
	    				}
	    				
	    			}
	    			catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}	    			
	    		}
	    		
	    		if((objMsg.getContent().equalsIgnoreCase("!test"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
		    	    	
	    			Message message = new MessageBuilder().append(" ").build();
	    			try {
						objChannel.sendFile(new File("C:/Users/Kympu/Desktop/KympBot/src/main/java/Kympu/KympBot/Images/DB.png"), message).queue();
					} catch (IOException e1) {
						objChannel.sendMessage("Error").complete();
					}
	    		}
	    		
	    		if((objMsg.getContent().equalsIgnoreCase("!ytch"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
			    			
			    			Document doc = null;
			    			try{	
			        			try {
			    					doc = Jsoup.connect("https://www.youtube.com/user/armouredgame/about").get();
			    				} catch (Exception ex) {
			    					System.err.print("\nError while fetching youtube search link: " + doc);
			    				}
			    				Elements urlDig = doc.select("span.about-stat:contains(subscribers)");	
			    				Element Filter = urlDig.first();

			    					String Send = Filter.text();
			    					System.out.println("test");
			    					System.out.println(Send);
			        			
			    			}
			    			
						catch(Exception ex){
		    				objChannel.sendMessage("No information found!").complete();						
	    			}	   			
	    		}
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!code"))
		    	    	&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
			    			
	    			String finalLink = "";
	    			String Message = objMsg.getContent();
	    			String Search = Message.toString().toLowerCase()
	    					.replaceAll("!code ", "")
	    					.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.com/search?q=stackoverflow+";	    			
	    			String GoogleSearch = GoogleLink + Search;
	    			Document doc = null;
	    			try{	
	    				try {
	    					doc = Jsoup.connect(GoogleSearch).get();
	    				} catch (Exception ex) {
	    					
	    					ex.printStackTrace();
	    				}
	    				Elements urlDig = doc.select("div#rcnt");
	    				Elements urlDig2 = urlDig.select("div#center_col");								
	    				for(Element context : urlDig2){																				
	    					String search = "overflow";								
	    					Element link = doc.select("div.med div._NId div.rc h3.r a:contains("+ search + ")").first();
	    					finalLink = link.attr("abs:href");
	    					if(finalLink.contains("https://en.wikipedia.org/wiki/%")){
	    						//objChannel.sendMessage("No information found!").complete();
	    						break;						
	    					}
	    					//System.out.print(finalLink + "\n");	
	    					//objChannel.sendMessage(finalLink).complete();
	    				}
	    				Document doc2 = null;
	    				try{	
	    					try {
	    						doc2 = Jsoup.connect(finalLink).get();
	    					} catch (Exception ex) {
	    						
	    						ex.printStackTrace();
	    					}
	    				
	    					
	    					
	    					
	    					//Title
	    					String Title ="Answer";
	    					String Status = "";
	    					//Answer Content
	    					String content = null;
	    					try{
	    					Elements contentDig = doc2.select("div#mainbar div#answers");
	    					Element contentF = contentDig.select("div.accepted-answer td.answercell div.post-text").first();
	    					content = contentF.text();
	    					//Side image
	    					Status = ":white_check_mark:";
	    					//System.out.println(content);
	    					}catch(Exception ex){
	    						try{
	    						Elements AcontentDig = doc2.select("div#mainbar div#answers");
	    						Element AcontentF = AcontentDig.select("div.answer td.answercell div.post-text").first();
	    						content = AcontentF.text();
	    						//System.out.println(content);
	    						//Side image
		    					Status = ":x:";
	    						}catch(Exception ex2){
	    							Elements AcontentDig = doc2.select("div.mw-content-text");
	    							Element AcontentFirst = AcontentDig.select("p:contains()").first();
	    							content = AcontentFirst.text();
	    						}
	    					}
	    					
	    					//Question Content
	    					String Qcontent = null;
	    					try{
	    					Elements QcontentDig = doc2.select("div#mainbar div#question");
	    					Element QcontentF = QcontentDig.select("td.postcell div.post-text").first();
	    					Qcontent = QcontentF.text();
	    					//System.out.println(content);
	    					}catch(Exception ex){
	    					
	    					}
	    					
	    					EmbedBuilder eb = new EmbedBuilder();    					
	    						eb.setTitle(Status + Title);
	    						eb.setDescription(content + "\n\n**More at: **" + finalLink);
	    							    					
	    	    			MessageEmbed Answer = eb.build();		    	    			

	    					EmbedBuilder eb2 = new EmbedBuilder();	
	    						eb2.setTitle(":question:" + "Question");
	    						eb2.setDescription(Qcontent);
	    					MessageEmbed Question = eb2.build();
	    					
	    					objChannel.sendMessage(Question).complete();
	    	    			objChannel.sendMessage(Answer).complete();
	    				}
	    					
	    				catch(Exception ex){
	    					objChannel.sendMessage("No information found!").complete();
	    				}
	    				
	    			}
	    			catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}	
	    			
	    		}	    		
	    		
    }
	    
	private static String searchType;
	public static String Pass(){
		return searchType;
	}
}
