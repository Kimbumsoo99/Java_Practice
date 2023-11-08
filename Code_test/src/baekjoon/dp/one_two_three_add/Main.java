package baekjoon.dp.one_two_three_add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                if (i < 3) {
                    dp[i] = i;
                } else if (i == 3) {
                    dp[i] = 4;
                } else {
                    dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
                }
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }

}
