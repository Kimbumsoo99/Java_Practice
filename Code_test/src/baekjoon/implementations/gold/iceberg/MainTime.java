package baekjoon.implementations.gold.iceberg;

// 풀이 성공 but 시간 초과 해결 위한 부분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5 5
0 0 0 0 0
0 1 1 1 0
0 1 0 1 0
0 1 1 1 0
0 0 0 0 0

2 2
1 0
0 1
 */

public class MainTime {
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
        ArrayList<int[]> iceberg = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (Graph[i][j] > 0) {
                    iceberg.add(new int[]{i, j});
                }
            }
        }
        int islandNum = 0;

        while (true) {
            visit = new boolean[N][M];
            for (int[] ice : iceberg) {
                if (!visit[ice[0]][ice[1]] && Graph[ice[0]][ice[1]] > 0) {
                    bfs(ice[0], ice[1]);
//                    System.out.println("\n\n");
                    islandNum++;
                }
            }
            for (int i = 0; i < iceberg.size(); i++) {
                int[] ice = iceberg.get(i);
                System.out.println(ice[0] + " " + ice[1] + " " + Graph[ice[0]][ice[1]] + " " + iceberg.size());
                iceHigher(ice[0], ice[1]);
            }
            if (islandNum > 1) {
                break;
            } else {
                year++;
                islandNum = 0;
            }
        }
        System.out.println(year + " " + iceberg.size());
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
//            System.out.println(tmp[0] + " " + tmp[1] + " " + Graph[tmp[0]][tmp[1]]);
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
//        drowGraph();
    }
}
