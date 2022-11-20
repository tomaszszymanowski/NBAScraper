import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj zakres dat dla którego pobrać dane,");
        System.out.println("podaj początkowy zakres w formacie yyMMdd: ");
        String start = scanner.next();
//        String startStr = "221115";
        System.out.println("podaj końcowy zakres w formacie yyMMdd: ");
        String end = scanner.next();
//        String endStr = "221115"
        // new line
        System.out.println();

        ArrayList<String> allGamestoSaveInExcel = new ArrayList<>();
        List<String> allLinksFromRange = getLinksFromDateRange(start, end);
        StringBuilder gameReadyToSave = new StringBuilder();

        for (String url : allLinksFromRange) {
            Document document = Jsoup.connect(url).get();


            String str = document.toString()
                    .replaceAll("- ", "-");

            Document doc = Jsoup.parse(str);
            Elements table = doc.getElementsByClass("sortable");


            for (Element e : table.select("tr").next()) {

                gameReadyToSave.append(e.child(1).text());
                gameReadyToSave.append(", "+ e.child(2).text());
                gameReadyToSave.append(", "+ e.child(3).text());
                gameReadyToSave.append(", "+ e.child(4).text());
                gameReadyToSave.append(", "+ e.child(5).text());
                gameReadyToSave.append(", "+ e.child(6).text());
                gameReadyToSave.append(", "+ e.child(7).text());
                gameReadyToSave.append(", "+ e.child(8).text());
                gameReadyToSave.append(", "+ e.child(9).text());
                gameReadyToSave.append(", "+ e.child(10).text());
                gameReadyToSave.append(", "+ e.child(11).text());
                gameReadyToSave.append(", "+ e.child(12).text());
                gameReadyToSave.append(", "+ e.child(13).text());
                gameReadyToSave.append(", "+ e.child(14).text());

                //gameReadyToSave.append(e.text());


                System.out.println(url);
                allGamestoSaveInExcel.add(String.valueOf(gameReadyToSave));
                gameReadyToSave.setLength(0);
            }

        }
        saveInExcel(allGamestoSaveInExcel);
    }


    static List<String> getLinksFromDateRange(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuMMdd");
        LocalDate localDateStart = LocalDate.parse(start, formatter);
        String textStart = localDateStart.format(formatter);
        LocalDate localDateEnd = LocalDate.parse(end, formatter);
        String textEnd = localDateEnd.format(formatter);

        int daysInPeriodAsIndex = (int) ChronoUnit.DAYS.between(localDateStart, localDateEnd);
        //System.out.println(daysInPeriodAsIndex);

        StringBuilder modifiedURL = new StringBuilder("https://www.progsport.com/basketball/bsk-predictions-221109.html");
        LocalDate localDateToInsertInURL = localDateStart;

        List<String> links = new ArrayList<>();

        for (int i = 0; i <= daysInPeriodAsIndex; i++) {

            String text = localDateToInsertInURL.format(formatter);
            //insert correct data to URL
            modifiedURL.replace(53, 59, text);
            links.add(modifiedURL.toString());
            localDateToInsertInURL = localDateToInsertInURL.plusDays(1);
        }
        return links;
    }

    static void saveInExcel(ArrayList<String> allGames) throws Exception {
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


// 221108 COL Akron Zips - South Dakota State 0 55 45 1.60 2.40 -4.5 42 58 0 0 0 144 70-70 11-10 0
/* funkcjonalności do opracowania:
    przed nazwą ligi dodanie daty dla orientacji co zostało pobrane
    usunięcie wszystkich białych znaków z pobieranych komórek
 *
 * */