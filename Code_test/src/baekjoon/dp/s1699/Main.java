package baekjoon.dp.s1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        System.out.println(dp[N]);
    }
}
