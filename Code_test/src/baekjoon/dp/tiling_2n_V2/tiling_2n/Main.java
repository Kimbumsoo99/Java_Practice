package baekjoon.dp.tiling_2n_V2.tiling_2n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2*n 타일링 2 문제다.
public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        dp = new int[N + 1];
        dp[1] = 1; // |
        dp[2] = 3; // || = ㅁ
        for (int i = 3; i < N + 1; i++) {
            dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10_007;
        }
        System.out.println(dp[N]);
    }

}
