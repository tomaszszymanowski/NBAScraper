import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.progsport.com/").get();
        //String title = doc.title();

        //Element element = doc.getElementById("anyid");
        String element = doc.getElementsByClass("F2").text();
        String element1 = doc.getElementsByClass("F1").text();

       // System.out.println(element);
        //System.out.println(element1);
        String[] arr = element.split("  ");
        String[] arr2 = element1.split("  ");

        List<String> list = new ArrayList<>(60);

        for(String s : arr){
            list.add(s);
        }

        for(String s : arr2){
            list.add(s);stworzony str
        }

        for(String s : list){
            System.out.println(s);
        }
    }
}
