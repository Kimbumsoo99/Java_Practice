package baekjoon.implementations.silver.s25644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] S = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i + 1] = Integer.parseInt(st.nextToken());
        }

        int max = S[N];
        for (int i = N - 1; i > 0; i--) {
            if (S[i] > max) {
                max = S[i];
            }
            dp[i] = Math.max(max - S[i], dp[i + 1]);
        }
        System.out.println(dp[1]);
    }

}
