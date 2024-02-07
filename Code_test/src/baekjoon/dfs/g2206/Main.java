package baekjoon.dfs.g2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[][][] visit;
    static int N, M, answer = Integer.MAX_VALUE;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[2][N][M];
        Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = tmp[j] - '0';
            }
        }
        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void bfs(){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visit[0][0][0] = true;
        dq.offer(new int[]{0, 0, 1, 0});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (tmp[0] == N - 1 && tmp[1] == M - 1) {
                answer = Math.min(answer, tmp[2]);
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    if (!visit[tmp[3]][nextY][nextX] && Graph[nextY][nextX] == 0) {
                        visit[tmp[3]][nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1, tmp[3]});
                    }
                    if (tmp[3] == 0 && !visit[1][nextY][nextX] && Graph[nextY][nextX] == 1) {
                        visit[1][nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1, 1});
                    }
                }
            }
        }
    }
    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }

}
