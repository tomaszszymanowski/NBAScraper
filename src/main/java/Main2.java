public class Main2 {
    public static void main(String[] args) {
        String str = "AR1 Regatas Corrientes - Instituto AC Cordoba 50 50 2.23 1.58 4.5 61 39 167.0 48 52 168 Regatas Corrientes - Instituto AC Cordoba";

        System.out.println(str.replaceAll("(?<=[a-z\\s])\\.", ""));
    }
}
