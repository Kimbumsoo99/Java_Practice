package baekjoon.dp.s14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        int max = 0;
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] <= N + 1) {
                if (i + T[i] <= N) {
                    max = Math.max(max, P[i] + dp[i + T[i]]);
                } else {
                    max = Math.max(max, P[i]);
                }

            }
            dp[i] = max;
        }
        System.out.println(dp[1]);
    }

}
