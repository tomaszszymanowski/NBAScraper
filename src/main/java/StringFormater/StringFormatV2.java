package StringFormater;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatV2 {

    public static String goodString(String source) {
        String[] arr = source.split("NBA");
       StringBuilder sb = new StringBuilder();
       String res = arr[1].replace(" : ", " ");
       sb.append(arr[1].charAt(0));


        for(int i = 1; i < res.length(); i++){
            if(Character.isUpperCase(res.charAt(i)) & Character.isLowerCase(res.charAt(i-1))){
                sb.append(",");
            }
            if(Character.isDigit(res.charAt(i)) & Character.isLetter(res.charAt(i-1))){
                sb.append(",");
            }
            sb.append(res.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String raw = "04.12.21NBAGolden State WarriorsPhoenix Suns118 : 96";
        System.out.println(goodString(raw));


    }
}
