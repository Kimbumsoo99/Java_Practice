package test;

// 문자열 관련
import java.util.*;
public class StringPr {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

//        for (int i = 0; i < begin.length(); i++) {
//            String tmp = begin;
//            for (int j = 'a'; j <= 'z'; j++) {
//                tmp = begin.substring(0, i) + (char) j + begin.substring(i + 1);
//                System.out.println(tmp);
//            }
//        }


        int[] dd = new int[]{1, 2, 3};
        ArrayList<String> qq = new ArrayList<>();
        qq.add("hit");
        qq.add("hot");

        System.out.println(qq.contains("hot"));
        System.out.println((char) (('Z' + 'A') / 2));
    }
}
