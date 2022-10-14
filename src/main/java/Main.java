import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        /*String[] arr = element.split("\\s{2}");
        String[] arr2 = element1.split("\\s{2}");


        List<String> listOfNumbers = new ArrayList<>(60);



        for (String s : list) {
            listOfNumbers.add(Main2.getNumbersFromString(s));
        }

        for (String st : listOfNumbers) {
            System.out.println(st);
        }*/
        Document doc = Jsoup.connect("https://www.progsport.com/basketball/bsk-predictions-211111.html").get();

//        Elements element = doc.getElementsByClass("F2");
//
//        System.out.println(element);

        String element = doc.getElementsByClass("F2").text();
        String element1 = doc.getElementsByClass("F1").text();
        //System.out.println(element);

        List<String> list = new ArrayList<>(60);
        List<String> list2 = new ArrayList<>(60);

        String[] arr = element.split("NBA ");
        String[] arr2 = element1.split("NBA ");

        list.addAll(Arrays.asList(arr));
        list.remove(0);

        list.addAll(Arrays.asList(arr2));
        list.remove(0);


        //list.remove(0);
        for (String s : list) {
            if(s.length() < 500){
                list2.add(s);
                System.out.print(s.length() + ",");
            }
        }

        for(String s : list2){
            System.out.println(s);
        }



    }

}

