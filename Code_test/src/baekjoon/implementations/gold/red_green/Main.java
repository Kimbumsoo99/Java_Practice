package baekjoon.implementations.gold.red_green;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static char[][] Graph;
    static boolean[][] visitNormal;
    static boolean[][] visitRedGreen;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new char[N][N];
        visitNormal = new boolean[N][N];
        visitRedGreen = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                Graph[i][j] = tmp.charAt(j);
            }
        }
        int countNormal = 0;
        int countRedGreen = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visitNormal[i][j]){
                    bfs(i, j);
                    countNormal++;
                }
                if (!visitRedGreen[i][j]) {
                    bfs2(i, j);
                    countRedGreen++;
                }
            }
        }
        System.out.println(countNormal + " " + countRedGreen);
    }

    static void bfs(int y, int x) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visitNormal[y][x] = true;
        char current = Graph[y][x];
        dq.offer(new int[]{y, x});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph.length) {
                    if (!visitNormal[nextY][nextX] && Graph[nextY][nextX] == current) {
                        visitNormal[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }

    static void bfs2(int y, int x) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visitRedGreen[y][x] = true;
        boolean blue = Graph[y][x] == 'B' ? true : false;
        dq.offer(new int[]{y, x});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph.length) {
                    if (!visitRedGreen[nextY][nextX]) {
                        if (blue && Graph[nextY][nextX] == 'B'
                            || !blue && Graph[nextY][nextX] != 'B') {
                            visitRedGreen[nextY][nextX] = true;
                            dq.offer(new int[]{nextY, nextX});
                        }
                    }
                }
            }
        }
    }
}
