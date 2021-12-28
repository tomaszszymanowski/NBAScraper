//package StringFormater;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class SringV3 {
//
//    public static void main(String[] args) {
//
//        //String[] linie = {"Pierwsza linia tekstu do zapisania", "druga linia - kilka liczb: 12, 23, 44", "trzecia linia"};
//        FileWriter fw = null;
//
//        try {
//            fw = new FileWriter("result.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        BufferedWriter bw = new BufferedWriter(fw);
////        try {
////            for (int i = 0; i < linie.length; i++) {
////                bw.write(linie[i]);
////                bw.newLine();
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        try {
//            bw.close();
//            fw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}