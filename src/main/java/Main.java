import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileWriter;
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


        Document doc = Jsoup.connect("https://www.progsport.com/basketball/bsk-predictions-221112.html").get();
        Elements elements = doc.getElementsByTag("html");

//        System.out.println(elements.get(0));
        StringBuilder sb = new StringBuilder(String.valueOf(elements.get(0).toString().replaceAll("><", ">0<").replaceAll("> <", ">0<")));

        //System.out.println(sb);
        String html = sb.toString().replaceAll("00", "0");
        doc = Jsoup.parse(html);

        elements = doc.getElementsByClass("F2");


        System.out.println(elements.size());
        int index = elements.size();
        int count = 0;
        while (count < index){
            System.out.println(elements.get(count).text().replaceAll("00 0", "").replaceAll("00 ", "").replaceFirst("0", ""));
            count += 3;
        }

        Elements elements1 = doc.getElementsByClass("F1");
        System.out.println(elements1.size());
        int index1 = elements.size();
        int count1 = 0;
        while (count1 < index1){
            System.out.println(elements.get(count1).text().replaceAll("00 0", "").replaceAll("00 ", "").replaceFirst("0", ";"));
            count1 += 3;
        }

//        try {
//            File myObj = new File("filename.txt");
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//        try {
//            FileWriter myWriter = new FileWriter("filename.txt");
//            myWriter.write(str);
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

//        List<String> list = new ArrayList<>(60);
//        List<String> list2 = new ArrayList<>(60);

//        String[] arr = element.split(" ");
//        String[] arr2 = element1.split(" ");
//
//        list.addAll(Arrays.asList(arr));
//        list.remove(0);
//
//        list.addAll(Arrays.asList(arr2));
//        list.remove(0);
//
//
//        //list.remove(0);
//        for (String s : list) {
//            if(s.length() < 500){
//                list2.add(s);
//                System.out.print(s.length() + ",");
//            }
//        }
//
//        for(String s : list2){
//            System.out.println(s);
//        }

    }

}

