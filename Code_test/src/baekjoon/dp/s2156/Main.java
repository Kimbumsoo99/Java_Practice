package baekjoon.dp.s2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] wine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        wine = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            wine[i + 1] = Integer.parseInt(br.readLine());
        }

        dp[1] = wine[1];
        for (int i = 1; i < N + 1; i++) {
            if (i > 3) {
                dp[i] = Math.max(dp[i - 2] + wine[i],
                    Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 1]));
            } else if (i > 1) {
                dp[i] = Math.max(dp[1] + wine[i], Math.max(dp[i - 1], wine[i - 1] + wine[i]));
            }
        }

        int answer = 0;
        for (int i = 1; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
