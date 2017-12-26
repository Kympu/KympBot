package Kympu.KympBot;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Kympu.KympBot.Commands.Other.GoogleFetch;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;

public class TestBot {
	public static void main(String[] args){
	
		String shopLink = "https://220.lv/lv/sadzives-tehnika/velas-masinas-new";
		String productLink = "";
		String Height = "";
		String Info = "";
		String 	Keyword1 = "Augstums", 
				Keyword2 = "",
				Keyword3 = "";
		int PgSlot = 2;
		Document shop = null;
		try {
			shop = Jsoup.connect(shopLink).get();
		}catch(Exception e){
			System.out.println("Could not connect to the shop link!");
		}
		Elements urlDig = shop.select("div.product-list-item");
		
		///////////////////////////////////////////
		//Main Loop for getting links to products//
		///////////////////////////////////////////
		int i = 0;
		String Link = "";
		Document product = null;
		for(Element Links : urlDig) {
			i++;
			Links = urlDig.select("a.cover-link").get(i);
			Link = Links.attr("abs:href");
			try {
			try {
				product = Jsoup.connect(Link).get();
			} catch (IOException e) {
				System.out.println("Cant connect to product link");
			}

				try {
					Elements H = product.select("div.row div:contains(Augstums:)");
					Element H2 = H.select("div.simple-value:contains(cm)").first();
					Height = H2.text();
				}catch(Exception e){
					Height = "No Info";
				}
				System.out.println(i + ": " + Height + "   " + Link);
				}
			catch(Exception e){
				Elements nextPage = Links.select("a.pageSlot" + PgSlot);
				PgSlot++;
				
			}
		}
				
		Elements nextPage = shop.select("div.paginator span.content");
		Element Page = nextPage.select("a").first();
		PgSlot++;
		String printTest = urlDig.toString();
		//System.out.println(nextPage);
		
		
	}
}
