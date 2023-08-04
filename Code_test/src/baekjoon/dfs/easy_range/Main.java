package baekjoon.dfs.easy_range;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 14940, 실버 I, 쉬운 최단거리 문제
public class Main {
    static int[][] Graph;
    static Integer[][] answer;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        answer = new Integer[N][M];
        visit = new boolean[N][M];

        int goll[] = new int[]{0, 0};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (Graph[i][j] == 2) {
                    goll = new int[]{i, j};
                }
            }
        }
        bfs(goll);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    if (Graph[i][j] == 0) {
                        answer[i][j] = 0;
                    }else{
                        answer[i][j] = -1;
                    }
                }
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(int[] goll){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{goll[0], goll[1], 0});
        visit[goll[0]][goll[1]] = true;
        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
            answer[tmp[0]][tmp[1]] = tmp[2];
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextX >= 0 && nextX < Graph[0].length && nextY >= 0 && nextY < Graph.length) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] == 1) {
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}
