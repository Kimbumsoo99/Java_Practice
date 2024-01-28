package baekjoon.dfs.g1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[][][] visit;
    static int[] dx = new int[]{1, 0, -1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[]{0, 1, 0, -1, -1, -2, -2, -1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        Graph = new int[H][W];
        visit = new boolean[31][H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = bfs(N, H - 1, W - 1);
        System.out.println(answer);
    }
    static int bfs(int K, int fY, int fX){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0, K, 0});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (tmp[0] == fY && tmp[1] == fX) {
                return tmp[3];
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextY < 0 || nextX < 0 || nextY >= Graph.length || nextX >= Graph[0].length) {
                    continue;
                }
                if (!visit[tmp[2]][nextY][nextX] && Graph[nextY][nextX] == 0) {
                    dq.offer(new int[]{nextY, nextX, tmp[2], tmp[3] + 1});
                    visit[tmp[2]][nextY][nextX] = true;
                }
            }
            if (tmp[2] > 0) {
                for (int i = 4; i < 12; i++) {
                    int nextY = tmp[0] + dy[i];
                    int nextX = tmp[1] + dx[i];
                    if (nextY < 0 || nextX < 0 || nextY >= Graph.length || nextX >= Graph[0].length) {
                        continue;
                    }
                    if (!visit[tmp[2] - 1][nextY][nextX] && Graph[nextY][nextX] == 0) {
                        dq.offer(new int[]{nextY, nextX, tmp[2] - 1, tmp[3] + 1});
                        visit[tmp[2] - 1][nextY][nextX] = true;
                    }
                }
            }
        }
        return -1;
    }
}
