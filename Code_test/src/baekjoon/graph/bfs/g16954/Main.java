package baekjoon.graph.bfs.g16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int N, Graph[][];
    static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1, 0 }, dy = { -1, -1, -1, 0, 1, 1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 8;
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                Graph[i][j] = tmp[j] == '.' ? 0 : 1;
            }
        }
        int start[] = { 7, 0 };
        if (bfs(start)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    /*
     * static boolean bfs(int[] start) { ArrayDeque<int[]> dq = new ArrayDeque<>();
     * if (Graph[start[0]][start[1]] == 1) return false; dq.offer(start);
     * boolean[][] visit = new boolean[N][N]; visit[start[0]][start[1]] = true; int
     * cnt = 0; while (!dq.isEmpty()) { int T = dq.size(); if (cnt == 3) return
     * true; System.out.println(dq); while (T-- > 0) { int[] tmp = dq.pollFirst();
     * System.out.println(Arrays.toString(tmp)); // 벽 확인 if (isMap(tmp[0], tmp[1])
     * && Graph[tmp[0]][tmp[1]] == 1) { System.out.println("나가리 "); continue; }
     *
     * for (int i = 0; i < dx.length; i++) { int nextY = tmp[0] + dy[i]; int nextX =
     * tmp[1] + dx[i]; if (isMap(nextY, nextX) && Graph[nextY][nextX] == 0) {
     * System.out.println(Arrays.toString(new int[] { nextY - 1, nextX }));
     * dq.offer(new int[] { nextY - 1, nextX }); } } } cnt++; } return false; }
     */

    static boolean bfs(int[] start) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        if (Graph[start[0]][start[1]] == 1)
            return false;
        dq.offer(start);
        int cnt = 0;
        while (!dq.isEmpty()) {
            boolean[][] visit = new boolean[N][N];
            int T = dq.size();
            if (cnt == 8)
                return true;
            while (T-- > 0) {
                int[] tmp = dq.pollFirst();
                // 벽 확인
                if (Graph[tmp[0]][tmp[1]] == 1)
                    continue;

                for (int i = 0; i < dx.length; i++) {
                    int nextY = tmp[0] + dy[i];
                    int nextX = tmp[1] + dx[i];
                    if (isMap(nextY, nextX) && Graph[nextY][nextX] == 0 && !visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        dq.offer(new int[] { nextY, nextX });
                    }
                }
            }
            cnt++;
            down();
        }
        return false;
    }

    static void down() {
        for (int i = N - 1; i > 0; i--) {
            Graph[i] = Graph[i - 1].clone();
        }
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}
