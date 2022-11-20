import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {


        String url = "https://www.progsport.com/basketball/bsk-predictions-221109.html";
        Document doc = Jsoup.connect(url).get();

        Elements table = doc.getElementsByClass("sortable");


        for (Element e : table.select("tr").next()) {

            System.out.print(e.child(1).text());
            System.out.print(" / "+ e.child(2).text());
            System.out.print(" * "+ e.child(3).text());
            System.out.print(", "+ e.child(4).text());
            System.out.print(", "+ e.child(5).text());
            System.out.print(", "+ e.child(6).text());
            System.out.print(", "+ e.child(7).text());
            System.out.print(", "+ e.child(8).text());
            System.out.print(", "+ e.child(9).text());
            System.out.print(", "+ e.child(10).text());
            System.out.print(", "+ e.child(11).text());
            System.out.print(", "+ e.child(12).text());
            System.out.print(", "+ e.child(13).text());
            System.out.println(", "+ e.child(14).text());
        }

    }
}
