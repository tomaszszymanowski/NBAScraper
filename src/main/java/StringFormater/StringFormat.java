package StringFormater;

import static java.lang.Character.isUpperCase;

public class StringFormat {

    public static String data(String source, String home){
        // 25.12.21NBAPhoenix SunsGolden State Warriors107 : 116
/*
1. String trzeba rozbić na poszczególne wyrazy
- pierwszy podział wystarczy "split na słowie NBA
- regex nazwa gospodarza
2. Wyrazy umieśścić w odpowiedniej strukturze
3.
* */


        StringBuilder sb = new StringBuilder();

        sb.append(source.charAt(0));
        for(int i = 1; i < source.length(); i++){
            sb.append(source.charAt(i));
            if(i == 10 | i == 7){
                sb.append(",");
            }

            if(Character.isUpperCase(source.charAt(i)) & Character.isLowerCase(source.charAt(i-1))){
                sb.insert(i+2,",");
            }
            if(Character.isDigit(source.charAt(i)) & Character.isLetter(source.charAt(i-1))){
                sb.insert(i+3,",");
            }



        }

        String res = sb.toString();
        return res;
    }

    public static void main(String[] args) {
        String homeTeam = "Phoenix Suns";
        String data = "22.12.21NBALos Angeles LakersPhoenix Suns90 : 108";
        System.out.println(data(data, homeTeam));
    }
}
