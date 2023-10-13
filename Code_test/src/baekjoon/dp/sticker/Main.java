package baekjoon.dp.sticker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N + 1];
            int[][] S = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = S[0][0];
            dp[1][1] = S[1][0];
            if (N == 1) {
                System.out.println(Math.max(dp[0][N], dp[1][N]));
                continue;
            }
            dp[0][2] = S[0][1] + S[1][0];
            dp[1][2] = S[1][1] + S[0][0];
            for (int i = 3; i < N + 1; i++) {
                dp[0][i] = S[0][i - 1] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = S[1][i - 1] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }

}
