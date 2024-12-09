package baekjoon.graph.dp.g1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] Graph, dp;
    static int[] dy = new int[]{0, 1, -1, 0}, dx = new int[]{1, 0, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int y, int x) {
        if (y == N - 1 && x == M - 1) {
            return 1;
        }
        if(dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isMap(nextY, nextX) && Graph[y][x] > Graph[nextY][nextX]) {
                dp[y][x] += dfs(nextY, nextX);
            }
        }

        return dp[y][x];
    }

    private static boolean isMap(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

}