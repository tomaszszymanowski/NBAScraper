import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.progsport.com/").get();
        //String title = doc.title();

        //Element element = doc.getElementById("anyid");
        //Elements element = doc.getElementsByClass("F2");

        String element = doc.getElementsByClass("F2").text();
        String element1 = doc.getElementsByClass("F1").text();


//        System.out.println(elementStr);

        String[] arr = element.split("  ");
        String[] arr2 = element1.split("  ");

        List<String> list = new ArrayList<>(60);

        for(String s : arr){
            list.add(s);
        }

        for(String s : arr2){
            list.add(s);
        }

        for(String s : list){
            System.out.println(s);
        }

        /*String input = element2;
        Pattern pattern = Pattern.compile("\\d+\\s");
        Pattern pattern2 = Pattern.compile("\\d\\d\\d\\s");

        Matcher m = pattern.matcher(input);
        Matcher m2 = pattern2.matcher(input);
        StringBuilder b = new StringBuilder();



        while(m.find()) {
            if(m2.find()){
                b.append("\n");
            }
            b.append(m.group(0));
        }
        System.out.println(b);*/
    }

    }

