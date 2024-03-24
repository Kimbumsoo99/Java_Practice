package baekjoon.dp.s11051;

import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dp = new long[N+1][N+1];

        for (int i = 0; i < N+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i+1; j++) {
                dp[i][j] = (dp[i-1][j-1] % 10007) + (dp[i-1][j] % 10007);
            }
        }
        System.out.println(dp[N][M] % 10007);
    }
}
