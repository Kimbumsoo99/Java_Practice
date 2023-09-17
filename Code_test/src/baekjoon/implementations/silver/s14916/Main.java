package baekjoon.implementations.silver.s14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (N == 1 || N == 3) {
            sb.append(-1);
        } else {
            int count = 0;
            if (N % 5 == 0) {
                count = N / 5;
            } else{
                count = N / 5;
                N = N % 5;
                if (N % 2 == 0) {
                    count = count + N / 2;
                } else {
                    N = N + 5;
                    count = (count - 1) + N / 2;
                }
            }
            sb.append(count);
        }
        System.out.println(sb);
    }

}
