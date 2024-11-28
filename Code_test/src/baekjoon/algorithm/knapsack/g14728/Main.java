package baekjoon.algorithm.knapsack.g14728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp; // 행, 열 -> N, K

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // K
            int B = Integer.parseInt(st.nextToken()); // S
            for (int j = 1; j < K + 1; j++) {
                if (j < A) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                } // j >= A
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A] + B);
            }
        }

        System.out.println(dp[N][K]);
    }
}