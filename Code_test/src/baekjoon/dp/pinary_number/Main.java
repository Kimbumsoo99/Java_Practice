package baekjoon.dp.pinary_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2193번, 실버 III, 이친수 문제
public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        System.out.println(dp[N][0] + dp[N][1]);
    }
}
