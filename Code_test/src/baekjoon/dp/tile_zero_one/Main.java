package baekjoon.dp.tile_zero_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 01타일, 실버 III, 1904번 문제
public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        dp = new long[N + 1];
        dp[1] = 1; // 1
        dp[2] = 2; // 11 00
        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }
        System.out.println(dp[N]);
    }
}
