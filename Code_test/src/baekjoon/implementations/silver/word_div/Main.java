package baekjoon.implementations.silver.word_div;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 단어 나누기, 실버 V
public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String tmp = make(str, i, j);
                list.add(tmp);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    private static String make(String str, int a, int b) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb1.append(str.substring(0, a)).reverse();
        sb2.append(str.substring(a, b)).reverse();
        sb3.append(str.substring(b)).reverse();
//        System.out.println(sb1.toString() + sb2.toString() + sb3.toString());
        return sb1.toString() + sb2.toString() + sb3.toString();
    }
}
