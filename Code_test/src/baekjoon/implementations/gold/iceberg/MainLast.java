package baekjoon.implementations.gold.iceberg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class MainLast {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;
    static int[][] Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int iceIslandNum = countIsland();

            if (iceIslandNum > 1) {
                break;
            } else if (iceIslandNum == 0) {
                year = 0;
                break;
            }

            bfs();
            year++;
        }
        System.out.println(year);
    }

    static int countIsland(){
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (!visited[i][j] && Graph[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int y, int x, boolean[][] visited){
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                if (!visited[nextY][nextX] && Graph[nextY][nextX] > 0) {
                    dfs(nextY, nextX, visited);
                }
            }
        }
    }

    static void bfs(){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Graph[i][j] > 0) {
                    dq.offerLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
            int sea = 0; // 바닷물

            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (!visited[nextY][nextX] && Graph[nextY][nextX] == 0) {
                        sea++;
                    }
                }
            }

            if (Graph[tmp[0]][tmp[1]] > sea) {
                Graph[tmp[0]][tmp[1]] -= sea;
            } else {
                Graph[tmp[0]][tmp[1]] = 0;
            }
        }
    }
}
