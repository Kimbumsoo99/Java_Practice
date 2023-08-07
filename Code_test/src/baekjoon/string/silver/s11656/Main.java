package baekjoon.string.silver.s11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 접미사 배열, 실 VI
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length(); i++) {
            String tmp = words.substring(i);
            list.add(tmp);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
