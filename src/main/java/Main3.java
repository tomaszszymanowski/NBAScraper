import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {

        String url = "https://www.progsport.com/basketball/bsk-predictions-221108.html";
        Document document = Jsoup.connect(url).get();

        Elements elements = document.getElementsByClass("sortable");

        for(Element el : elements.select("tr").next()){
            System.out.println(el.text());
        }
    }
}

// w tr można spóbować powstawiać zerw w miejsce ><
//
// NBA San Antonio Spurs - Denver Nuggets 46 54 3.50 1.30 7.5 66 34 234.5 64 36 229 109-115
/* spóbuje na następnym kroku napisać dwa regexy-
*   jeden który usuwa wszystkie liczby a drugi którzy usunie wszystkie litery
*   powinnp tp daćdwa stringi łatwiejsze do dalszego wykorzystania*/