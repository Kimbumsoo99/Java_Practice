package baekjoon.dp.relay_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속합, 실버 II
public class Main {
    static int dp[];
    static int S[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        S = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i + 1] = Integer.parseInt(st.nextToken());
        }
        dp[N] = S[N];
        int max = dp[N];
        for (int i = N - 1; i > 0; i--) {
            dp[i] = S[i];
            if (dp[i] + dp[i + 1] > dp[i]) {
                dp[i] += dp[i + 1];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
