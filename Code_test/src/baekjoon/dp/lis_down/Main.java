package baekjoon.dp.lis_down;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] dp = new int[N + 1];
            int[] s = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < N + 1; i++) {
                dp[i] = 1;
                for (int j = 1; j < i; j++) {
                    if (s[i] < s[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
}
