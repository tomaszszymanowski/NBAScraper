import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        String str = "NBP Milwaukee Bucks - Brooklyn Nets 55 45 1.60 2.40 -4.5 42 58 229.0 38 62 234 97-107 Milwaukee Bucks - Brooklyn Nets 97-107 NBP Phoenix Suns - Sacramento Kings 71 29 1.40 3.00 -6.5 59 41 217.0 28 72 226 104-105 Phoenix Suns - Sacramento Kings 104-105";
        //getNumbersFromString(str);
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.indexOf("NBP",50));
        System.out.println(sb.subSequence(0, 124));
    }

    public static String getNumbersFromString(String str) {
        StringBuilder sb = new StringBuilder();
        String mydata = str;
        Pattern pattern = Pattern.compile("([0-9.-]{2,}\\s)");
        Matcher matcher = pattern.matcher(mydata);
        while (matcher.find())
        {
            sb.append(matcher.group(1));
        }
        return sb.toString();
    }
}
