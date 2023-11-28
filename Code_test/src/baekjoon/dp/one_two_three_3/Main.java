package baekjoon.dp.one_two_three_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1_000_000_009;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            long[] dp = new long[1000001];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < 1000001; i++) {
                dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % MOD;
            }

            for (int test_case = 0; test_case < T; test_case++) {
                int N = Integer.parseInt(br.readLine());
                sb.append(dp[N]).append("\n");
            }
            System.out.println(sb);
        }
}
