package swea.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, Graph[][], min, dp[][];
    static final int INF = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            Graph = new int[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j)
                        continue;
                    dp[i][j] = Graph[i][j];
                    if (dp[i][j] == 0)
                        dp[i][j] = INF;
                }
            }

            for (int current = 0; current < N; current++) {
                for (int i = 0; i < N; i++) {
                    if (i == current) {
                        continue;
                    }
                    for (int j = 0; j < N; j++) {
                        if (j == i)
                            continue;
                        dp[i][j] = Math.min(dp[i][j], dp[i][current] + dp[current][j]);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += dp[i][j];
                }
                min = Math.min(min, sum);
            }
            System.out.println("#" + test_case + " " + min);
        }
    }
}
