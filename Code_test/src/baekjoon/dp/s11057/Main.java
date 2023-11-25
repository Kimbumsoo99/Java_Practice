package baekjoon.dp.s11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long[][] dp = new long[N + 1][10];
            for (int i = 0; i < 10; i++) {
                dp[1][i] = 1;
            }

            for (int i = 2; i < N + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i - 1][k] % 10007;
                    }
                }
            }

            long answer = 0;
            for (int i = 0; i < 10; i++) {
                answer += dp[N][i];
            }
//            System.out.println(dp[3][1]);
            System.out.println(answer % 10007);
        }

}
