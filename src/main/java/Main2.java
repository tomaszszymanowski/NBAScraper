import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {

        String url = "https://www.progsport.com/basketball/bsk-predictions-221108.html";
        Document document = Jsoup.connect(url).get();


        String str = document.toString()
                .replaceAll("></", ">0<")
                .replaceAll("- ", "-");

        document = Jsoup.parse(str);
        //Document doc2 = Jsoup.parse(html);

        Elements elementsF1 = document.getElementsByClass("F1");
        Elements elementsF2 = document.getElementsByClass("F2");


        extractData(elementsF2, "tr.f2");
        extractData(elementsF1, "tr.f1");


    }

    private static void extractData(Elements elementsF2, String query) {
        for( Element element : elementsF2){
            String s = element.select(query).next().text().replaceAll(" - ", "-");
            if(s.equals("")){
                continue;
            }
            System.out.println(s);
        }
    }
}
