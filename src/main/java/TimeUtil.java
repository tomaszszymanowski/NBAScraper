import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TimeUtil {

    static List<String> getLinksFromDateRange() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj zakres dat dla którego pobrać dane,");
        System.out.println("podaj początkowy zakres w formacie yyMMdd:  roboczo 221109");
//        String startStr = scanner.next();
        String startStr = "221108";
        System.out.println("podaj końcowy zakres w formacie yyMMdd: roboczo 22109 ");
//        String endStr = scanner.next();
        String endStr = "221108";

        // new line
        System.out.println();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuMMdd");
        LocalDate localDateStart = LocalDate.parse(startStr, formatter);
        String textStart = localDateStart.format(formatter);
        LocalDate localDateEnd = LocalDate.parse(endStr, formatter);
        String textEnd = localDateEnd.format(formatter);

//        System.out.println(textStart);
//        System.out.println(textEnd);
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


}
