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


    static List<String> getRangeOfDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj zakres dat dla którego pobrać dane,");
        System.out.print("podaj początkowy zakres w formacie yyMMdd: ");
        String startStr = scanner.next();
//        String startStr = "220101";
        System.out.print("podaj końcowy zakres w formacie yyMMdd: ");
        String endStr = scanner.next();
//        String endStr = "220104";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuMMdd");
        LocalDate localDateStart = LocalDate.parse(startStr, formatter);
        String textStart = localDateStart.format(formatter);
        LocalDate localDateEnd = LocalDate.parse(endStr, formatter);
        String textEnd = localDateEnd.format(formatter);

        System.out.println(textStart);
        System.out.println(textEnd);
        int daysInPeriod = (int) ChronoUnit.DAYS.between(localDateStart, localDateEnd);
        //System.out.println(daysInPeriod);

        LocalDate ld = localDateStart;
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("uuMMdd");

        List<String> links = new ArrayList<>();

        StringBuilder sbLinkTest = new StringBuilder("https://www.progsport.com/basketball/bsk-predictions-221109.html");

        for (int i = 0; i <= daysInPeriod; i++) {

            String text = ld.format(formatters);
            sbLinkTest = sbLinkTest.replace(53, 59, text);
            links.add(sbLinkTest.toString());
            ld = ld.plusDays(1);
        }

//        for (String s : links) {
//            System.out.println(s);
//        }
        return links;
    }


}
