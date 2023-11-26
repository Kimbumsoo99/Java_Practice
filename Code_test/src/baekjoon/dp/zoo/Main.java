package baekjoon.dp.zoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long[][] dp = new long[N + 1][3];
            for (int i = 0; i < 3; i++) {
                dp[1][i] = 1;
            }

            for (int i = 2; i < N + 1; i++) {
                dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 9901;
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            }

            int answer = 0;
            for (int i = 0; i < 3; i++) {
                answer += dp[N][i];
            }
            System.out.println(answer % 9901);
        }

}
