package baekjoon.implementations.silver.s1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 이어쓰기, 1515번, 실버 III
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int idx = 1;
        while (num.length() > 0) {
            String tmp = String.valueOf(idx++);
            for (int i = 0; i < tmp.length(); i++) {
                if (num.length() == 0) {
                    break;
                }
                if (tmp.substring(i, i + 1).equals(num.substring(0, 1))) {
//                    System.out.println(num.substring(0, 1));
                    if (num.length() > 1) {
                        num = num.substring(1);
                    } else {
                        num = "";
                    }
                }
            }
        }
        System.out.println(idx - 1);
    }

}
