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
        List<String> linksFromRange = TimeUtil.getLinksFromDateRange();
        ArrayList<String> allGames = new ArrayList<>();
        StringBuilder sbLink = new StringBuilder();

        // główna pętala programu
        for (String s : linksFromRange) {

            sbLink.append(s);
            System.out.println(s);

            //pobranie documentu ze strony jako html
            Elements elements = getElementsFromURL(sbLink);

            //parsowanie html na string do edycji i ponowna konwersja na html
            StringBuilder sb = new StringBuilder((elements.get(0).toString()
                    .replaceAll("><", ">0<").replaceAll("> <", ">0<")));

            String html = sb.toString().replaceFirst("00", ";");
            Document doc2 = Jsoup.parse(html);



            // drukowanie wierszy z tagiem F1
            StringBuilder stringBuilder = new StringBuilder();
            Elements elementsF1 = doc2.getElementsByClass("F1");
            int indexF1 = elementsF1.size();
            int countF1 = 0;

            while (countF1 < indexF1) {
                stringBuilder.append(elements.get(countF1).text()
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

                String str = stringBuilder.toString().replaceFirst("& 0", "&").replaceFirst("0", ";");

                stringBuilder.setLength(0);
                stringBuilder.append(str);
                if(str.contains("Bac&k to the Top")){
                    stringBuilder.setLength(0);
                }
                System.out.println(stringBuilder.toString());

                stringBuilder.setLength(0);
                countF1 += 3;
            }


            //drukowanie wierszy z tagiem F2
            stringBuilder.setLength(0);
            Elements elementsF2 = doc2.getElementsByClass("F2");
            int indexF2 = elementsF2.size();
            int countF2 = 0;
            while (countF2 < indexF2) {
                stringBuilder.append(elements.get(countF2).text()
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

                String str = stringBuilder.toString().replaceFirst("& 0", "&").replaceFirst("0", ";");

                stringBuilder.setLength(0);
                stringBuilder.append(str);
                if(str.contains("Bac&k to the Top")){
                    stringBuilder.setLength(0);
                }
                System.out.println(stringBuilder.toString());

                stringBuilder.setLength(0);
                countF2 += 3;
            }
            sbLink.setLength(0);
        }

        //saveInExcel(allGames);


    }

    private static Elements getElementsFromURL(StringBuilder sbLink) throws IOException {
        Element element = Jsoup.connect(sbLink.toString()).get();
        try {
            element = Jsoup.connect(sbLink.toString()).get();

        }catch (IOException exception){

        }

        return element.getElementsByTag("html");
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

