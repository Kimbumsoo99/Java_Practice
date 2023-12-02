package baekjoon.dp.moving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Fail {
    static int[][] Graph;
    static int[][] dp;
    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = Graph[1][1];
        bfs(N, M);
        System.out.println(dp[N][M]);
    }

    private static void bfs(int N, int M) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{1, 1});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 2; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextY <= N && nextX <= M) {
                    if (dp[tmp[0]][tmp[1]] + Graph[nextY][nextX] > dp[nextY][nextX]
                        || (dp[tmp[0]][tmp[1]] == 0 && dp[nextY][nextX] == 0)) {
                        dp[nextY][nextX] = dp[tmp[0]][tmp[1]] + Graph[nextY][nextX];
                        dq.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }

}
