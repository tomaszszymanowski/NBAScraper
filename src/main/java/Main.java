import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println(" __      __      ___.       _________                                         ___.           ___________                                   \n" +
//                "/  \\    /  \\ ____\\_ |__    /   _____/ ________________  ______   ___________  \\_ |__ ___.__. \\__    ___/___   _____ _____    ______________\n" +
//                "\\   \\/\\/   // __ \\| __ \\   \\_____  \\_/ ___\\_  __ \\__  \\ \\____ \\_/ __ \\_  __ \\  | __ <   |  |   |    | /  _ \\ /     \\\\__  \\  /  ___/\\___   /\n" +
//                " \\        /\\  ___/| \\_\\ \\  /        \\  \\___|  | \\// __ \\|  |_> >  ___/|  | \\/  | \\_\\ \\___  |   |    |(  <_> )  Y Y  \\/ __ \\_\\___ \\  /    / \n" +
//                "  \\__/\\  /  \\___  >___  / /_______  /\\___  >__|  (____  /   __/ \\___  >__|     |___  / ____|   |____| \\____/|__|_|  (____  /____  >/_____ \\\n" +
//                "       \\/       \\/    \\/          \\/     \\/           \\/|__|        \\/             \\/\\/                           \\/     \\/     \\/       \\/");

        // tworzenie listy zawierającej linki z podanego zakresu dat
        List<String> linksFromRange = TimeUtil.getRangeOfDate();

        ArrayList<String> allGames = new ArrayList<>();

        // główna pętala programu
        for (String s : linksFromRange) {

            StringBuilder sbLink = new StringBuilder(s);


            //pobranie documentu ze strony
            Elements elements = getElementsFromURL(sbLink);


            //parsowanie html na string do edycji i ponowna konwersja na html
            StringBuilder sb = new StringBuilder(String.valueOf(elements.get(0).toString()
                    .replaceAll("><", ">0<").replaceAll("> <", ">0<")));
            String html = sb.toString().replaceAll("00", ";");
            Document doc2 = Jsoup.parse(html);



            // drukowanie wierszy z tagiem F1
            StringBuilder stringBuilder = new StringBuilder();
            Elements elements1 = doc2.getElementsByClass("F1");
            int index1 = elements1.size();
            int count1 = 0;

            while (count1 < index1) {
//                allGames.add(elements1.get(count1).text()
//                        .replaceAll("00 ", ";").replaceAll("00 ", "")
//                        .replaceFirst("0", ";").replaceAll("- ", "-"));

                stringBuilder.append(elements1.get(count1).text()
                        .replaceAll("00 ", "").replaceAll("00 ", ";")
                        .replaceFirst("0", ";").replaceAll("- ", "-"));
                stringBuilder =stringBuilder.insert(3,'$');
                System.out.println(stringBuilder.toString());
                stringBuilder.setLength(0);
                count1 += 3;
            }


            //drukowanie wierszy z tagiem F2
            stringBuilder.setLength(0);
            Elements elements2 = doc2.getElementsByClass("F2");
            int index = elements2.size();
            int count = 0;
            while (count < index) {
//                allGames.add(elements1.get(count).text()
//                        .replaceAll("00 ", "").replaceAll("00 ", "")
//                        .replaceFirst("0", ";").replaceAll("- ", "-"));

                stringBuilder.append(elements1.get(count).text()
                        .replaceAll("00 ", "").replaceAll("00 ", ";")
                        .replaceFirst("0", ";").replaceAll("- ", "-"));
                stringBuilder =stringBuilder.insert(3,'$');
                if(stringBuilder.charAt(stringBuilder.length()-1) == '0' & stringBuilder.charAt(stringBuilder.length()-2) == ' '){
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }

                System.out.println(stringBuilder.toString());
                stringBuilder.setLength(0);
                count += 3;
            }

        }

        //saveInExcel(allGames);


    }

    private static Elements getElementsFromURL(StringBuilder sbLink) throws IOException {
        Element doc = Jsoup.connect(sbLink.toString()).get();
        try {
            doc = Jsoup.connect(sbLink.toString()).get();

        }catch (IOException exception){

        }


        return doc.getElementsByTag("html");
    }


    private static void saveInExcel (ArrayList < String > allGames) throws Exception {
        String[] matches = allGames.toArray(new String[allGames.size()]);
        Workbook workbook = new Workbook("wyniki.xlsx");
        Worksheet worksheet = workbook.getWorksheets().get(0);
        int maxDataRow = worksheet.getCells().getMaxDataRow();
        int maxDataCol = worksheet.getCells().getMaxDataColumn();

        if (maxDataCol == -1 & maxDataRow == -1) {
            worksheet.getCells().importArray(matches, 0, 0, true);
            workbook.save("wyniki.xlsx");
        } else {
            worksheet.getCells().importArray(matches, maxDataRow, maxDataCol, true);
            workbook.save("wyniki.xlsx");
        }


    }
}

