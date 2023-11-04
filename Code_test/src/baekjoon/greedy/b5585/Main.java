package baekjoon.greedy.b5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000 - Integer.parseInt(br.readLine());
        int answer = 0;
        while (N != 0) {
            if (N >= 500) {
                answer += N / 500;
                N %= 500;
            } else if (N >= 100) {
                answer += N / 100;
                N %= 100;
            } else if (N >= 50) {
                answer += N / 50;
                N %= 50;
            } else if (N >= 10) {
                answer += N / 10;
                N %= 10;
            } else if (N >= 5) {
                answer += N / 5;
                N %= 5;
            } else if (N >= 1) {
                answer += N / 1;
                N %= 1;
            }
        }
        System.out.println(answer);

    }

}
