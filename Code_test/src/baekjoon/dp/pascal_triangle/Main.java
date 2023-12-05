package baekjoon.dp.pascal_triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] dp = new int[31][31];
            for (int i = 1; i <= N; i++) {
                dp[i][1] = 1;
            }
            for (int i = 2; i < N + 1; i++) {
                for (int j = 2; j < i + 1; j++) {
                    if (j == i) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[N][K]);
        }

}
