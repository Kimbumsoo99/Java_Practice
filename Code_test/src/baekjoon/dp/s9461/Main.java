package baekjoon.dp.s9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            long dp[];
            if (N > 5) {
                dp = new long[N + 1];
            } else {
                dp = new long[6];
            }
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;

            for (int i = 6; i < N + 1; i++) {
                dp[i] = dp[i - 5] + dp[i - 1];
            }
            System.out.println(dp[N]);
        }
    }
}
