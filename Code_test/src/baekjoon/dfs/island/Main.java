package baekjoon.dfs.island;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!q.isEmpty()){
            int[] tmp = q.poll();

            for (int i = 0; i < 8; i++) {
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

        return 1;
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // 가로
            int Y = Integer.parseInt(st.nextToken()); // 세로
            if(X == 0 && Y == 0) break;

            Graph = new int[Y][X];
            visit = new boolean[Y][X];
            for (int i = 0; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken()); // 1은 땅, 0은 바다
                }
            }
            int count = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if(!visit[i][j] && Graph[i][j] == 1){
                        count += bfs(j, i); // x, y
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
