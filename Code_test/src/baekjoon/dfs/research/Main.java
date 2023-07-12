package baekjoon.dfs.research;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] Graph;
    static int answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs() {
        int count = 0;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] virus = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Graph[i][j] == 2) {
                    virus[i][j] = true;
                    dq.offer(new int[]{i, j});
                }
            }
        }

        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
//            System.out.println(tmp[0] + " " + tmp[1]);
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                    if (Graph[nextY][nextX] == 0 && !virus[nextY][nextX]) {
                        dq.offer(new int[]{nextY, nextX});
                        virus[nextY][nextX] = true;
                    }
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(virus[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Graph[i][j] == 0 && !virus[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
    static void recursive(int[][] ifGraph, int call) {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(ifGraph[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(call + "번째\n");

        if (call == 3) {
            int tmp = bfs();
            answer = Math.max(answer, tmp);
            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ifGraph[i][j] == 0) {
                    ifGraph[i][j] = 1;
                    recursive(ifGraph, call + 1);
                    ifGraph[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
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
        recursive(Graph, 0);
        System.out.println(answer);
    }
}
