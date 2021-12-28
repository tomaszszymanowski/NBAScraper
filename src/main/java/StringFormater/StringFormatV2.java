package StringFormater;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatV2 {

    public static void main(String[] args) {
        String text    =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";

        String regex = "is";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }
    }
}
