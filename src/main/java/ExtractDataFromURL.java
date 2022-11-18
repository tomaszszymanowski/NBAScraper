import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class ExtractDataFromURL {

    public static void main(String[] args)  {

        Document document = null;
        try{
            String url = "https://www.progsport.com/basketball/bsk-predictions-221115.html";
            document = Jsoup.connect(url).get();
        }catch (Exception e){
            e.printStackTrace();
        }


        //pobranie documentu ze strony jako html
        Elements elements = document.getElementsByTag("html");

        //parsowanie html na string do edycji i ponowna konwersja na html
        StringBuilder sb = new StringBuilder((elements.get(0).toString()
                .replaceAll("></td", ">0</td").replaceAll("> </td", ">0</td")));

        String html = sb.toString();
        Document doc2 = Jsoup.parse(html);


        // drukowanie wierszy z tagiem F1
        StringBuilder stringBuilder = new StringBuilder();

        elements = doc2.getElementsByClass("F1");

        int index = elements.size();
        int count = 0;

        while (count < index) {
            stringBuilder.append(elements.get(count).text()
                    .replaceFirst("0 ", "")
                    .replaceAll(" - ", "-")
                    .replaceFirst(" 0 0 ", " 0 ")
                    .replace("- ", "-"));
            stringBuilder.insert(3,"&");

            if (stringBuilder.charAt(stringBuilder.length() - 1) == '0' & stringBuilder.charAt(stringBuilder.length() - 2) == ' ') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (stringBuilder.charAt(4) == '0') {
                stringBuilder.deleteCharAt(4);
                stringBuilder.deleteCharAt(3);
            }

            String str = stringBuilder.toString().replaceFirst("& 0", "&").replaceFirst(" 0 ", ";");

            stringBuilder.setLength(0);
            stringBuilder.append(str);
            if(str.contains("Bac&k to the Top")){
                stringBuilder.setLength(0);
            }
            System.out.println(stringBuilder.toString());

            stringBuilder.setLength(0);
            count += 3;
        }

        // drukowanie wierszy z F2
        stringBuilder.setLength(0);

        elements = doc2.getElementsByClass("F2");

        index = elements.size();
        count = 0;



        while (count < index) {
            stringBuilder.append(elements.get(count).text()
                    .replaceFirst("0 ", "")
                    .replaceAll(" - ", "-")
                    .replaceFirst(" 0 0 ", " 0 ")
                    .replace("- ", "-"));
            stringBuilder.insert(3,"&");

            if (stringBuilder.charAt(stringBuilder.length() - 1) == '0' & stringBuilder.charAt(stringBuilder.length() - 2) == ' ') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (stringBuilder.charAt(4) == '0') {
                stringBuilder.deleteCharAt(4);
                stringBuilder.deleteCharAt(3);
            }

            String str = stringBuilder.toString().replaceFirst("& 0", "&").replaceFirst(" 0 ", ";");

            String[] arr = str.split(";");
            System.out.println(arr[1]);
            String[] numArr = arr[1].split(" ");
            System.out.println(numArr[1]);
            stringBuilder.setLength(0);
            stringBuilder.append(str);
            if(str.contains("Bac&k to the Top")){
                stringBuilder.setLength(0);
            }
            System.out.println(stringBuilder.toString());



            stringBuilder.setLength(0);
            count += 3;
        }




    }



}
