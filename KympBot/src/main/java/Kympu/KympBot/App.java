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
	    	
	    					  //////////////////////////////////
	    					 //////////Side Projects///////////
	    					//////////////////////////////////
	   

    	/*	if((objMsg.getAuthor().getName().equalsIgnoreCase("Kympu")
    				&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId())){
    			boolean FlirtTarget = true;
    			String Content = objMsg.getContent();
    			if(Content.startsWith("!Target")){
    				FlirtTarget = true; 
    			}
    			String EditContent = Content.replace("!Target ", "");
    			
    			if(EditContent == "!stop"){
    				FlirtTarget = false;
    			}

    			
    			//////Targeting System//////
    			
    			if(FlirtTarget){
	    			
	    			if((objMsg.getAuthor().getName().equals("KympBot"))){
	    				objChannel.sendMessage("").complete();
	    			}
	    			
	    			else{
	    				if(Flirt == true){
	    			Random rnd = new Random();
					int random = rnd.nextInt(10) + 1;
					
					switch(random){
					
					case 1:
						objChannel.sendMessage("Hey " + target +" :3").complete();
						break;
						
					case 2:
						objChannel.sendMessage("You look beutiful today, "  + target + " ^^").complete();
						break;
						
					case 3:	
						objChannel.sendMessage("I could look into your eyes all day, "  + target + "!").complete();
						break;
						
					case 4:
						objChannel.sendMessage("You are absolutely, astoundingly gorgeous, "  + target + "!").complete();
						break;
					
					case 5:
						objChannel.sendMessage("You Have Such a Positive Charisma, "  + target + ". :)").complete();
						break;
					
					case 6:
						objChannel.sendMessage("I love your perception of reality "  + target + "!").complete();
						break;
					
					case 7:
						objChannel.sendMessage("Lets team up and destroy all humans, "  + target + " ;)").complete();
						break;
						
					case 8:
						objChannel.sendMessage("Haha, you are so funny "  + target + "!").complete();
						break;
						
					case 9:
						objChannel.sendMessage("What do you think of the Kympu guy? I think he is cool as fuck!").complete();
						break;
						
					case 10:
						objChannel.sendMessage("I like your style, its amazing!").complete();
						break;
						
					}
	    		}
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}				
	    	}	    			
	    }
    			
    		}*/
		
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!mwsearch")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			String input = objMsg.getContent();
		    		String Search = input.toString()
		    				.replaceAll(" ", "+");
		    		
		    		String GoogleLink = "https://www.google.lv/search?q=wiki+monster+warlord";
		    			
		    			String lookup = Search.toLowerCase()
			    				.replaceAll("!mwsearch", "");
		    			
		    			String GoogleSearch = GoogleLink + lookup;		
		    			
		    			Document site = null;
					try{	
		    			try {
							site = Jsoup.connect(GoogleSearch).get();
						} catch (Exception ex) {
							System.err.print("\nError while fetching Google search link: " + GoogleSearch);
						}
						Elements body = site.select("div#rcnt");
						Elements urlDig = body.select("div#center_col");								
		    			for(Element context : urlDig){												
	
							String search = "wiki";								
							Element link = site.select("div.med div._NId h3 a:contains("+ search + ")").first();
							String finalLink = link.attr("abs:href");
							if(finalLink == ("http://monsterwarlord.wikia.com/")){
								objChannel.sendMessage("No information found!").complete();
								break;						
							}
							objChannel.sendMessage(finalLink).complete();			
		    			}
					}
					catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}	    		
	    		}
	    		
	    		 ///////////////////////////////////////////////
	    		/////////////////Google Search/////////////////
	    	   ///////////////////////////////////////////////
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!wiki "))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			String finalLink = "";
	    			String Message = objMsg.getContent();
	    			String Search = Message.toString().toLowerCase()
	    					.replaceAll("!wiki ", "")
	    					.replaceAll(" ", "+");
	    			
	    			String GoogleLink = "https://www.google.com/search?q=wikipedia+";	    			
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
	    					Elements titleDig = doc2.select("h1.firstHeading");
	    					String Title = titleDig.text();
	    					//System.out.println("Title: " + Title);
	    					
	    					//Image
	    					String imgUrl = "";
	    					Boolean imgT = true;
	    					try{
	    					Elements imgDig = doc2.select("div#content");
	    					Element imgLink = imgDig.select("tbody a.image img").first();
	    					imgUrl = imgLink.attr("abs:src");
	    					//System.out.println("Image: " + imgUrl);
	    					}catch(Exception ex){
	    						try{
	    	    					Elements imgDig = doc2.select("div#content");
	    	    					Element imgLink = imgDig.select("a.image img").first();
	    	    					imgUrl = imgLink.attr("abs:src");
	    	    					//System.out.println("Image: " + imgUrl);
	    	    					}catch(Exception e1){
	    	    						System.out.println("Image: " + "No image");
	    	    						imgT = false;
	    	    					}
	    					}
	    				
	    					//Content
	    					String content = null;
	    					try{
	    					Elements contentDig = doc2.select("div#content");
	    					Element contentF = contentDig.select("p").first();
	    					content = contentF.text();
	    					//System.out.println("Content: " + content);
	    					}catch(Exception ex){
	    						//objChannel.sendMessage("No content").complete();
	    					}
	    					EmbedBuilder eb = new EmbedBuilder();
	    					
	    					//Side image
	    					String imageUrl2 = null;
	    					Boolean sideImage = true;
	    					try{
	    					Elements imageDig = doc2.select("div.WikiaPageContentWrapper div.floatleft");
	    					Element imageFirst = imageDig.select("a").first();
	    					imageUrl2 = imageFirst.attr("abs:href");
	    					//System.out.println("Side Image: " + imageUrl2);
	    					}catch(Exception ex){
	    						imageUrl2 = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Wikipedia_Logo_1.0.png/220px-Wikipedia_Logo_1.0.png";
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
	    			//	objChannel.sendMessage("No information found!").complete();
	    			}
	    		}
	    		
	    		 /////////////////////////////////////////////////
	    		//////////////////Youtube Search/////////////////
	    	   /////////////////////////////////////////////////
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!youtube"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			String YouTubeLink = null;
	    			String Message = objMsg.getContent();
		    		
		    		YouTubeLink = "https://www.youtube.com/results?sp=EgIQAQ%253D%253D&q=";
		    		String YouTube = "https://www.youtube.com";	    
		    		
		    		String Search = Message.toLowerCase().toString()
		    				.replaceAll("!youtube ", "")
		    				.replaceAll(" ", "+");
		    		if(Search.contains("#playlist")){
		    			Search = Search.toString()
			    				.replaceAll("#playlist", "");
		    			YouTubeLink = "https://www.youtube.com/results?sp=EgIQAw%253D%253D&q="; 
		    			}
		    		if(Search.contains("#new")){
		    			Search = Search.toString()
			    				.replaceAll("#new", "");
		    			YouTubeLink = "https://www.youtube.com/results?sp=EgIIAw%253D%253D&q=";		    			
		    			}
	    			
		    			String YouTubeSearch = YouTubeLink + Search;		
		    			
		    			Document doc = null;
		    			try{	
		        			try {
		    					doc = Jsoup.connect(YouTubeSearch).get();
		    				} catch (Exception ex) {
		    					System.err.print("\nError while fetching youtube search link: " + YouTubeSearch);
		    				}
		    				Elements urlDig = doc.select("div#body-container div#page-container div#content");	
		        			for(Element results : urlDig){												
		    					Element method2 = results.select("div.yt-lockup-content h3").first();
		    					Elements Link = method2.select("a[href]");
		    					
		    					String FinalLink = Link.attr("href");

		    					String Send = YouTube + FinalLink;
		    					
		    					objChannel.sendMessage(Send).complete();
		        			}
		    			}
		    			
					catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}    			    		
	    		}
	    		
	    		 ////////////////////////////////////////////////
	    		//////////////////Urban Search//////////////////
	    	   ////////////////////////////////////////////////
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!urban "))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			String input = objMsg.getContent();
	    			String UrbanLink = "http://www.urbandictionary.com/define.php?term=";	    			
	    			String Search = input.toLowerCase().toString()
		    				.replaceAll("!urban ", "")
		    				.replaceAll(" ", "+");
	    			
	    			String lookup = Search;		    			
	    			String UrbanSearch = UrbanLink + lookup;		
	    			
	    			Document doc = null;
				try{	
	    			try {
						doc = Jsoup.connect(UrbanSearch).get();
					} catch (Exception ex) {
						
						ex.printStackTrace();
					}
	    			
					Elements body = doc.select("div#content");
	    			for(Element content : body){												
						Element urlDig = content.select("div.meaning").first();
						String urlDig2 = urlDig.toString();
						String Send = Jsoup.parse(urlDig2).text();					
						String Searching = input.toString()
		    					.replaceAll("!urban", "")
		    					.replaceAll("!Urban", "");
						
						objChannel.sendMessage("```From Urban dictionary\n\nSearching:" + Searching + "\n\n" + Send + "```").complete();					
	    			}
				}
				catch(Exception ex){
					objChannel.sendMessage("Article too long! \n" + UrbanSearch).complete();
				}	    			
	    	}
	    	
	    		 /////////////////////////////////////////////////
	    		//////////////////Twitch Search//////////////////
	    	   /////////////////////////////////////////////////
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!twitch"))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			String input = objMsg.getContent();
		    		String Search = input.toLowerCase().toString()
		    				.replaceAll("!twitch ", "")
		    				.replaceAll(" ", "+");
		    		
		    		String GoogleLink = "https://www.google.lv/search?q=twitch+";   			
		    			String GoogleSearch = GoogleLink + Search;		
		    			
		    			Document doc = null;
					try{	
		    			try {
							doc = Jsoup.connect(GoogleSearch).get();
						} catch (Exception ex) {
							System.err.print("\nError while fetching Goolge Search link: " + GoogleSearch);
						}
		    			String lockOn = "twitch";
		    			Elements body = doc.select("div#cnt div#center_col");
	        			for(Element context : body){												
	        				Element urlDig = context.select("div.rc h3 a:contains(" + lockOn +")").first();
	        				Elements Link = urlDig.select("a[href]");
	        				String FinalLink = Link.attr("href");
	        						
	        				objChannel.sendMessage(FinalLink).complete();
							
		    			}
					}
					catch(Exception ex){
	    				objChannel.sendMessage("No information found!").complete();
	    			}								    			    		
	    		}
	    		
	    		 ///////////////////////////////////////////////
	    		//////////////////Game Search//////////////////
	    	   ///////////////////////////////////////////////
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!game")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			boolean error = false;

	    			String Message = objMsg.getContent();
	    			String ytSend = "";
		    		String IGDBLink = "https://www.igdb.com/games/";
		    		String wikiSend = "";
		    		String GoogleLink = "https://www.google.lv/search?q=wikipedia+game+";		    		
		    		String Search = Message.toString().toLowerCase()
							.replace("!game ", "")
							.replaceAll(" ", "+");
		    		String WikiLink = GoogleLink + Search;

		    		Document site = null;
		    		try{	
		    			try {
		    				site = Jsoup.connect(WikiLink).get();
		    			} catch (Exception ex) {
		    				
		    				ex.printStackTrace();
		    			}
		    			Elements body = site.select("div#rcnt");
		    			Elements body2 = body.select("div#center_col");								
		    			for(Element context : body2){														    					
		    				String lockOn = "wikipedia";		    					
		    				Element link = site.select("div.med div._NId h3 a:contains("+ lockOn + ")").first();
		    				String linkRedirect = link.attr("abs:href");

		    				site = Jsoup.connect(linkRedirect).get();
		    				Elements wikiUrlDig = site.select("div#content");
		    				Elements wikiTitleSearch = wikiUrlDig.select("h1.firstHeading");
		    				String wikiTitle = wikiTitleSearch.toString();
		    				wikiSend = Jsoup.parse(wikiTitle).text();
		    				wikiSend = wikiSend
		    						.replace(" (", "<")
									.replace(")", ">")
									.replaceAll("<.*?>", "");
		    			}
		    		}
		    		catch(Exception ex){
	    			
		    		}	    			    		
		    			String lookup = wikiSend.toString()
		    					.replaceAll(" ", "-")
		    					.replaceAll(":", "")
		    					.replaceAll("'", "")
		    					.toLowerCase();	    			
		    			String GameSearch = IGDBLink + lookup;	
		    			
		    		Document doc = null;
					
		    		try{	
		    			try {
		    				doc = Jsoup.connect(GameSearch).get();
		    			} catch (Exception ex) {
		    				System.err.print("\nError while fetching game link: " + GameSearch);
		    			}
		    			Elements ErrorBody = doc.select("div.main-container h4");
		    			String ErrorBody2 = ErrorBody.toString();
		    			String ErrorSend = Jsoup.parse(ErrorBody2).text();
		    			
		    			if(ErrorSend.startsWith("We couldn't find")){
		    				objChannel.sendMessage("```No information found!```").complete();
		    				error = true;
		    			}	    			
		    			if(GameSearch.equals("https://www.igdb.com/games/")){
		    				objChannel.sendMessage("```No information found!```").complete();
		    				error = true;
		    			}	    			
		    			if(!error){
		    			Elements urlDig = doc.select("div.main-container div.gamepage-header div.gamepage-tabs");		
		    			Elements urlDig2 = doc.select("div.main-container div.gamepage-header div.gamepage-tabs p");
	
		    			////////////////////Filtering////////////////////////
		    			String GenreTitleDig = urlDig2.toString();
		    			String getText = Jsoup.parse(GenreTitleDig).text();
		    			
		    			String Filter = getText.replace("No lists available, why not create one ?", "");
		    			String GenreTitle = Filter
		    					.replace("Genre: ", "\nGenre: ")
		    					.replace("Platforms: ", "\n\nPlatforms: ");
		    			////////////////////////////////////////////////////

		    			String shit = Filter;
		    			String bodytest = urlDig.toString();
		    			String Send = Jsoup.parse(bodytest).text();
		    			Send = Send
		    					.replace("About Add To Share ", "")
		    					.replace(shit, "")
		    					.replaceAll("Facebook", "")
		    					.replaceAll("Twitter", "")
		    					.replaceAll("Official Website", "")
		    					.replaceAll("Tweet", "")
		    					.replaceAll("Google", "")
		    					.replaceAll("Wikipedia", "")
		    					.replaceAll("Wiki", "")		    					
		    					.replaceAll("Youtube", "")
		    					.replaceAll("Twitch", "")
		    					.replaceAll("Instagram", "")
		    					.replaceAll("Create new list", "")
		    					.replace("?", "")
		    					.replace("  a", "")
		    					.replaceAll("No lists available, why not create one", "");
		    			String ReadMore = "";
		    			if(Send.contains("Read More")){
		    				ReadMore = "Read More: " + GameSearch + "'";
		    				Send = Send.replace("Read More", "\n");
		    			
		    			}
		    			
		    			char[] string = new char [250];
		    			string = Send.toCharArray();
		    			String End = Send.toString();
		    			GenreTitle = GenreTitle.replaceAll(" ,", ",");
		    				
		    				Document ytdoc = null;
		    				try{	
		    					String YTLink = wikiSend.replace(" ", "+");
		    					String youTube = "https://www.youtube.com/results?sp=EgIQAQ%253D%253D&q=";
		    					String youTubeLink = youTube + YTLink + "trailer";	
		    					
		    					String YouTube = "https://www.youtube.com";
		    					
		    	    			try {
		    						ytdoc = Jsoup.connect(youTubeLink).get();
		    					} catch (Exception ex) {
		    						
		    						ex.printStackTrace();
		    					}
		    					Elements ytbody = ytdoc.select("div#body-container");
		    					Elements ytbody2 = ytbody.select("div#page-container");
		    					Elements ytbody3 = ytbody2.select("div#content");	
		    	    			for(Element results : ytbody3){												
		    						Element method2 = results.select("div.yt-lockup-content h3").first();
		    						Elements Link = method2.select("a[href]");
		    						
		    						String FinalLink = Link.attr("href");
		    						ytSend = YouTube + FinalLink; 					
		    	    			}
		    				}	    				
		    			catch(Exception ex){
		    				System.err.print("\nError while fetching youtube link at game search: " + ytSend);
		    			}
		    				objChannel.sendMessage("```Game Title: " + wikiSend + "\n"+ GenreTitle + "\n\n" + End + "```" + ReadMore + "\n\n" +ytSend).complete();			    			
		    			}
		    		}		    		
		    		catch(Exception ex){
		    			objChannel.sendMessage("No information found!").complete();
		    		}
		    	}
	    		
	    		if(objMsg.getContent().toLowerCase().startsWith("!ask")
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
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
					String SendMessage = Emoji + FirstPart + ".";
					objChannel.sendMessage(SendMessage).complete();
					if(FirstPart == "Fuck you"){
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						objChannel.sendMessage(":middle_finger:" + ":sunglasses:").complete();						
					}	    					
		    	} 	    		
	    		
	    		////////////////////////////////////////////////
	    	   //////////////////Image Search//////////////////
	    	  ////////////////////////////////////////////////
	    		
	    		if((objMsg.getContent().toLowerCase().startsWith("!Image ") 
	    				|| objMsg.getContent().toLowerCase().startsWith("!image "))
		    			&& e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
	    			
	    			String Message = objMsg.getContent();
		    		String Search = Message.toString()
		    				.replaceAll("!image ", "")
		    				.replaceAll("!Image ", "")
		    				.replaceAll(" ", "+");
		    		
		    		String GoogleLinkP1 = "https://www.google.lv/search?q=";
		    		String GoogleLinkP2 = "&source=lnms&tbm=isch&sa";
		    			
		    			String lookup = Search;
		    			String GoogleSearch = GoogleLinkP1 + lookup + GoogleLinkP2;		
		    			
		    			Document doc = null;
		    			try{	
		    				try {
		    					doc = Jsoup.connect(GoogleSearch).get();
		    				} catch (Exception ex) {
		    					
		    					ex.printStackTrace();
		    				}
		    				Elements body = doc.select("div#rcnt");
		    				Elements body2 = body.select("div#center_col");								
		    				for(Element context : body2){												
		    					Element urlDig = context.select("div.med div#rg div.rg_di img").first();
		    					String urlDig2 = urlDig.toString();
		    						urlDig2 = urlDig2.replaceAll(".*?name=", "").replaceAll("jsaction=.*.", "");
		    						urlDig2 = urlDig2.replaceAll("\"", "");					
		    					String finalLink = GoogleSearch + urlDig2;
		    					Document doc2 = null;
		    					try{
		    						 	doc2 = Jsoup.connect(finalLink).get(); 
		    					} catch (Exception ex) {
		    						System.err.print("\nError while fetching the image link: " + finalLink);
		    					}
		    					Elements imgbody = doc2.select("div#rcnt div#center_col div.med div#isr_mc");	    					
		    					Element imgmethod2 = imgbody.select("div.rg_meta").first();
		    					String imgmethod32 = imgmethod2.toString();
		    					String imgTestlink = Jsoup.parse(imgmethod32).text();	    					
		    						imgTestlink = imgTestlink.replaceFirst(".*?http", "http")
		    							.replaceFirst("\",", "\n");
		    						imgTestlink = imgTestlink.split("\n")[0];
		    				//	objChannel.sendMessage(imgTestlink).complete();
		    					
		    					EmbedBuilder eb = new EmbedBuilder();
		    					eb.setImage(imgTestlink);
				    			MessageEmbed embed = eb.build();
				    			objChannel.sendMessage(embed).complete();
		    				}
		    			}
		    			catch(Exception ex){
		    				objChannel.sendMessage("No image found!").complete();
		    			}
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
	    				System.out.println("Stack Link: " + finalLink);
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
	    					String Title = "Answer";
	    				
	    					//Content
	    					String content = null;
	    					try{
	    					Elements contentDig = doc2.select("div#mainbar div#answers");
	    					Element contentF = contentDig.select("div.accepted-answer td.answercell div.post-text").first();
	    					content = contentF.text();
	    					//System.out.println(content);
	    					}catch(Exception ex){
	    						Elements contentDig = doc2.select("div.mw-content-text");
	    						Element contentFirst = contentDig.select("p:contains()").first();
	    						content = contentFirst.text();
	    					}
	    					EmbedBuilder eb = new EmbedBuilder();	
	    					
	    					//Side image
	    					String imageUrl2 = "http://www.iconsdb.com/icons/preview/green/checkmark-xxl.png";				
	    					
	    					eb.setTitle(Title);
	    					eb.setDescription(content + "\n\n**More at: **" + finalLink);
	    					eb.setThumbnail(imageUrl2);
	    					
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
	    		
    }
}
