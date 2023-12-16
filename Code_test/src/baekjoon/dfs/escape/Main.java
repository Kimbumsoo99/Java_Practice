package baekjoon.dfs.escape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visit;
    static int[][] Graph;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[N][M];
        int startX = 0;
        int startY = 0;
        ArrayList<int[]> waterList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (tmp.charAt(j) == 'D') {
                    Graph[i][j] = 4000; // 골
                } else if (tmp.charAt(j) == 'S') {
                    Graph[i][j] = 2800; // 위치
                    startY = i;
                    startX = j;
                } else if (tmp.charAt(j) == 'X') {
                    Graph[i][j] = 3000; // 돌
                } else if (tmp.charAt(j) == '*') {
                    Graph[i][j] = 1; // 물
                    waterList.add(new int[]{i, j, 1}); // 물 위치 y, x, 이동한 횟수
                }
            }
        }
        waterBFS(waterList);
//        draw(N, M, Graph);
        visit = new boolean[N][M];
        int answer = bfs(startY, startX);
        if (answer == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }

    }

    private static void draw(int N, int M, int[][] graph) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Graph[i][j] > 2500) {
                    System.out.print("$" + "\t\t");

                } else {
                    System.out.print(Graph[i][j] + "\t\t");
                }
            }
            System.out.println();
        }
    }

    private static void waterBFS(ArrayList<int[]> waterList) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int[] wa : waterList) {
            dq.offer(wa);
            visit[wa[0]][wa[1]] = true;
        }

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextX < Graph[0].length
                    && nextY < Graph.length) {
                    if (Graph[nextY][nextX] < tmp[2] && !visit[nextY][nextX]) {
                        Graph[nextY][nextX] = tmp[2] + 1;
                        visit[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                    }
                }
            }
        }
    }

    private static int bfs(int startY, int startX) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[]{startY, startX, 1});

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextX < Graph[0].length
                    && nextY < Graph.length) {
                    if (Graph[nextY][nextX] == 4000) {
                        return tmp[2];
                    } else if (!visit[nextY][nextX] && ((Graph[nextY][nextX] > tmp[2] + 1
                        && Graph[nextY][nextX] <= 2800) || Graph[nextY][nextX] == 0)) {

                        visit[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                    }
                }
            }

        }
        return -1;
    }

}
