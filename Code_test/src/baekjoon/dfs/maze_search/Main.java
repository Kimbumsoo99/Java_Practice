package baekjoon.dfs.maze_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] Graph;
    static boolean[][] visit;
    static int cnt = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static void bfs(){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
//        int count = 1;
//        int x, y;
//        x = y = 0;
        dq.offer(new int[]{0, 0, 1});
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
//            System.out.println(tmp[0] + " " + tmp[1] + " " + N + " " + M);
            int y = tmp[0];
            int x = tmp[1];
            int count = tmp[2];

            if (x == M-1 && y == N-1) {
                cnt = Math.min(cnt, count);
                // continue;
                // 어처피 짧은거부터 들리기 때문에 return도 상관 없음
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (x + dx[i] >= 0 && x + dx[i] < M && y + dy[i] >= 0 && y + dy[i] < N) {
                    if (!visit[y + dy[i]][x + dx[i]] && Graph[y + dy[i]][x + dx[i]] == 1) {
                        visit[y + dy[i]][x + dx[i]] = true;
                        dq.offer(new int[]{y + dy[i], x + dx[i], count + 1});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs();
        System.out.println(cnt);
    }
}
