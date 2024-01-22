package baekjoon.dp.s17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Four Squares, 실버 3
// Arrays.fill() 사용
// BufferedReader 사용
public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[50001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        dp[5] = 2;

        for (int i = 6; i < N + 1; i++) {
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (j * j == i) {
                    dp[i] = 1;
                    break;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}

