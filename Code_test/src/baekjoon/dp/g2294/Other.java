package baekjoon.dp.g2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Other {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] coin = new int[N+1];
            for(int i = 1; i <= N; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }

            int[] dp = new int[K+1];
            Arrays.fill(dp, Integer.MAX_VALUE-1);
            dp[0] = 0;

            for(int i = 1; i <= N; i++) {
                for(int j = coin[i]; j <= K; j++) {
                    dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
                }
            }
            System.out.println(dp[K] == Integer.MAX_VALUE-1 ? -1 : dp[K]);
        }
}
