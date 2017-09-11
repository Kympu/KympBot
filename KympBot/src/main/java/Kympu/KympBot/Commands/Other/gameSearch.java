package Kympu.KympBot.Commands.Other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class gameSearch {
	public MessageEmbed Message(MessageReceivedEvent e){
		boolean error = false;
		MessageEmbed embed = null;
		Message objMsg = e.getMessage();
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
				error = true;
			}	    			
			if(GameSearch.equals("https://www.igdb.com/games/")){
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
				EmbedBuilder build = new EmbedBuilder();
					build.setTitle(wikiSend);
					build.setDescription(GenreTitle + "\n" + End + "\n\n" + ReadMore);
					embed = build.build();
					//SendToMain = "```Game Title: " + wikiSend + "\n"+ GenreTitle + "\n\n" + End + "```" + ReadMore + "\n\n" + ytSend;			    			
			}
		}		    		
		catch(Exception ex){
		}
		
		return embed;
	}
}
