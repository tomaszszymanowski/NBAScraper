import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        String str = "Denver Nuggets - Indiana Pacers 74 26 2.25 1.60 4.5 80 20 207.0 48 52 207 101- 98 Denver Nuggets - Indiana Pacers 101- 98 ";
        System.out.println(getNumbersFromString(str));
//        StringBuilder sb = new StringBuilder(str);

//        System.out.println(sb.indexOf("NBP",50));
//        System.out.println(sb.subSequence(0, 124));
    }

    public static String getNumbersFromString(String str) {
        StringBuilder sb = new StringBuilder();
        String mydata = str;
        Pattern pattern = Pattern.compile("([0-9.-]{2,}\\s)");
        Matcher matcher = pattern.matcher(mydata);
        while (matcher.find())
        {
            sb.append(matcher.group());
        }
        return sb.toString();
    }
}
