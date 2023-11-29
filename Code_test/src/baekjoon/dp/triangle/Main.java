package baekjoon.dp.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        s = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = st.countTokens();
            for (int j = 1; j < tmp + 1; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = s[1][1];
        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = s[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int max = dp[N][1];
        for (int i = 2; i < N + 1; i++) {
            if (max < dp[N][i]) {
                max = dp[N][i];
            }
        }
        System.out.println(max);
    }
}
