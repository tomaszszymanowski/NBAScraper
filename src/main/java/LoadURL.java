import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class
LoadURL {
    public static void main(String[] args) throws IOException {


        File input = new File("Crystal Palace - Arsenal, Premier, England, Aug 5, 2022 _ Sportalic.com.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        Element body = doc.body();

        List<Elements> linkedWords = new LinkedList<>();
        linkedWords.add(body.getElementsByTag("h1"));

        Elements strteams = body.getElementsByTag("h1");
        String sb = "";
        sb = strteams.toString();

//        for(Elements str : linkedWords){
//            System.out.println(str);
//        }

//        System.out.println();
//        System.out.println(sb);
//
        sb = sb.replaceAll("</h1>", "");
        String[] arr = sb.split("<h1>");
//        for(String st : arr){
//            System.out.print(st);
//        }
        System.out.print(arr[1]);
        System.out.print(arr[2]);
//        System.out.print(body.getElementsByTag("h1"));

//        System.out.print(body.getElementsByClass("game-result"));
//        System.out.print(body.getElementsByClass("game-extended-result"));
//        System.out.print(body.getElementsByClass("sodds"));
//        System.out.print(body.getElementsByClass("odd"));




//        Element headerDiv = doc.select("div.game-result").first();
//        System.out.println("Id: " + headerDiv.id());
        }
    }

