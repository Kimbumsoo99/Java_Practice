package baekjoon.dfs.organic_cabbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int tmp = test();
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }

    static int test() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Graph = new int[Y][X];
        visit = new boolean[Y][X];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Graph[y][x] = 1;
        }
        int count = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (!visit[i][j] && Graph[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        visit[y][x] = true;
        q.offer(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextY < Graph.length && nextX >= 0 && nextX < Graph[0].length) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] == 1) {
                        q.offer(new int[]{nextY, nextX});
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}
