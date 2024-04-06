package baekjoon.algorithm.tsp.g2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp, Graph;
    static int N;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Graph = new int[N][N];
        dp = new int[N][(1 << N) - 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 1));
    }

    static int dfs(int cur, int flag){
        if (flag == ((1 << N) - 1)) {
            if(Graph[cur][0] == 0) return INF;
            return Graph[cur][0];
        }

        if (dp[cur][flag] != -1) {
            return dp[cur][flag];
        }
        dp[cur][flag] = INF;

        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) == 0 && Graph[cur][i] != 0) {
                dp[cur][flag] = Math.min(dfs(i, flag | (1 << i)) + Graph[cur][i], dp[cur][flag]);
            }
        }

        return dp[cur][flag];
    }
}
