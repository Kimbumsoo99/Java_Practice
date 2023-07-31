package baekjoon.implementations.gold.iceberg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 빙산, 골 IV, 2573번
public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int year = 0;
    static int N;
    static int M;


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
        int islandNum = 0;

        while (true) {
            visit = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && Graph[i][j] != 0) {
                        bfs(i, j);
                        islandNum++;
                    }
                }
            }
            if (islandNum > 1) {
                break;
            } else {
                year++;
                islandNum = 0;
            }

            int[][] tmp = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmp[i][j] = iceHigher(i, j);
                }
            }
            Graph = tmp;
        }
        System.out.println(year);
    }

    static void drowGraph(){
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int iceHigher(int y, int x){
        if (Graph[y][x] == 0) {
            return 0;
        }
        int tmp = Graph[y][x];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                if (Graph[nextY][nextX] == 0) {
                    tmp--;
                }
            }
        }
        if (tmp < 0) {
            return 0;
        }
        return tmp;
    }

    static void bfs(int y, int x){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{y, x});
        visit[y][x] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] > 0) {
                        visit[nextY][nextX] = true;
                        dq.offerLast(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
