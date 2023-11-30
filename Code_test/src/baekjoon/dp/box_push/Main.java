package baekjoon.dp.box_push;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] s;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        s = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (s[i] > s[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
