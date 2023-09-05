package baekjoon.implementations.bronze.b3059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int asciiSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 'A'; i <= 'Z'; i++) {
            asciiSum += i;
        }
//        System.out.println(asciiSum);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            boolean[] visit = new boolean['Z' + 1];
            int answer = asciiSum;
            for (char c : tmp.toCharArray()) {
                if (!visit[c]) {
                    answer -= (int) c;
                    visit[c] = true;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
