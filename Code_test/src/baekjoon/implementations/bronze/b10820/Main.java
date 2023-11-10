package baekjoon.implementations.bronze.b10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str == null || str.length() == 0) {
                break;
            }
            int U = 0; // 대문자
            int D = 0; // 소문자
            int N = 0; // 숫자
            int B = 0; // 공백

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') {
                    B++;
                } else if ((int) ch >= 'a' && (int) ch <= 'z') {
                    D++;
                } else if ((int) ch >= 'A' && (int) ch <= 'Z') {
                    U++;
                } else if ((int) ch >= '0' && (int) ch <= '9') {
                    N++;
                }
            }
            sb.append(D + " " + U + " " + N + " " + B + "\n");
        }
        System.out.println(sb);
    }
}
