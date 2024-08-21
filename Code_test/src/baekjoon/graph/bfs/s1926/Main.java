package baekjoon.graph.bfs.s1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Graph[][];
    static int count = 0, max = 0;
    static boolean[][] visit;
    static int[] dx={1,0,0,-1}, dy = {0, 1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && Graph[i][j] == 1) {
                    count++;
                    max = Math.max(max, bfs(new int[]{i, j}));
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    static int bfs(int[] start){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        visit[start[0]][start[1]] = true;
        int cnt = 1;

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nY = tmp[0] + dy[i];
                int nX = tmp[1] + dx[i];
                if (isMap(nY, nX) && !visit[nY][nX] && Graph[nY][nX] == 1) {
                    dq.offer(new int[]{nY, nX});
                    cnt++;
                    visit[nY][nX] = true;
                }
            }
        }
        return cnt;
    }

    static boolean isMap(int y, int x){
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
