package baekjoon.dp.coin_1;

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
            int[] dp = new int[K + 1];
            int[] s = new int[N + 1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                s[i + 1] = Integer.parseInt(br.readLine());
            }

            for (int i = 1; i <= N; i++) {
                int coin = s[i];
                for (int j = coin; j < K + 1; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            System.out.println(dp[K]);

        }

}
