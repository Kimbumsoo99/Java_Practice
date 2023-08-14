package baekjoon.implementations.bronze.kmp_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// KMP는 왜 KMP일까?, 2902번, 브II
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean check = true;
        String answer = "";
        for (char c : str.toCharArray()) {
            if(check) answer += c;
            check = false;

            if(c == '-') check = true;
        }
        System.out.println(answer);
    }
}
