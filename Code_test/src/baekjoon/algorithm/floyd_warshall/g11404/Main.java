package baekjoon.algorithm.floyd_warshall.g11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dp[][];
    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = INF;
                if (i == j) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            dp[A][B] = Math.min(dp[A][B], C);
        }

        for (int choice = 1; choice < N + 1; choice++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][choice] + dp[choice][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (dp[i][j] >= INF) {
                    sb.append(0 + " ");
                } else {
                    sb.append(dp[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
