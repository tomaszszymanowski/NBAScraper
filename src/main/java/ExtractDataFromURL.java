import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtractDataFromURL {

    public static void main(String[] args) throws IOException {

        // tworzenie listy zawierającej linki z podanego zakresu dat
        List<String> linksFromRange = TimeUtil.getLinksFromDateRange();

        ArrayList<String> allGames = new ArrayList<>();
        StringBuilder sbLink = new StringBuilder();

        // główna pętala programu
        for (String s : linksFromRange) {

            sbLink.append(s);
            System.out.println(s);

            Document document = null;
            try {
                String url = s;
//                String url = "https://www.progsport.com/basketball/bsk-predictions-221115.html";
                document = Jsoup.connect(url).get();
            } catch (Exception e) {
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

            Elements elements1 = doc2.getElementsByClass("F1");

            int index = elements1.size();
            int count = 0;

            while (count < index) {
                stringBuilder.append(elements1.get(count).text()
                        .replaceFirst("0 ", "")
                        .replaceAll(" - ", "-")
                        .replaceFirst(" 0 0 ", " 0 ")
                        .replace("- ", "-"));
                stringBuilder.insert(3, "&");

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
                if (str.contains("Bac&k to the Top")) {
                    stringBuilder.setLength(0);
                }
                System.out.println(stringBuilder.toString());

                stringBuilder.setLength(0);
                count += 3;
            }

            // drukowanie wierszy z F2
            stringBuilder.setLength(0);

            Elements elements2 = doc2.getElementsByClass("F2");

            index = elements2.size();
            count = 0;


            while (count < index) {
                stringBuilder.append(elements2.get(count).text()
                        .replaceFirst("0 ", "")
                        .replaceAll(" - ", "-")
                        .replaceFirst(" 0 0 ", " 0 ")
                        .replace("- ", "-"));
                stringBuilder.insert(3, "&");

                if (stringBuilder.charAt(stringBuilder.length() - 1) == '0' & stringBuilder.charAt(stringBuilder.length() - 2) == ' ') {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                if (stringBuilder.charAt(4) == '0') {
                    stringBuilder.deleteCharAt(4);
                    stringBuilder.deleteCharAt(3);
                }

                String str = stringBuilder.toString().replaceFirst("& 0", "&").replaceFirst(" 0 ", ";");


                if (str.contains("Bac&k to the Top")) {
                    stringBuilder.setLength(0);
                }

                stringBuilder.setLength(0);
                count += 3;
            }


//        Document doc = Jsoup.connect("https://www.progsport.com/basketball/bsk-predictions-221116.html").get();
//        Elements elementsF1 = doc.getElementsByClass("F2");
//
//
//        sb = new StringBuilder(doc.getElementsByClass("F2").toString());
//        StringBuilder sb = new StringBuilder(doc.getElementsByClass("Tr8l").toString());
//        StringBuilder sb = new StringBuilder(String.valueOf(doc.getElementsByClass("F2")));

//        System.out.println(sb);

//        String html = sb.toString();
//        System.out.println(html);
//        Document doc2 = Jsoup.parse(html);


//        StringBuilder sbe = new StringBuilder(elementsF1.get(0).toString());

            //System.out.println(sbe);

//        sbe.insert(sbe.length()-5, "#");
//        System.out.println(sbe);


//
//        int indexF1 = elementsF1.size();
//        int countF1 = 0;
//
//        StringBuilder sb = new StringBuilder();
//        while (countF1 < indexF1) {
//            sb.append(elementsF1.get(countF1).text().replaceAll("- ", "-"));
//            sb =sb.insert(3,'$');
//
//            System.out.println(sb.toString());
//            sb.setLength(0);
//            countF1 += 3;
//        }


        }


    }
}
