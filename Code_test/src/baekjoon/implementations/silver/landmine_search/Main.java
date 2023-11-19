package baekjoon.implementations.silver.landmine_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] mine;
    static int[][] Graph;
    static int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static boolean gameOver = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mine = new boolean[N][N];
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == '*') {
//                    System.out.println(i + " " + j);
                    mine[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == 'x') {
                    Graph[i][j] = find(i, j);
                } else {
                    Graph[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < Graph[0].length; j++) {
                if (gameOver && mine[i][j]) {
                    sb.append("*");
                } else if (Graph[i][j] != -1) {
                    sb.append(Graph[i][j]);
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int y, int x) {
        if (mine[y][x]) {
            gameOver = true;
        }
        int count = 0;
        for (int i = 0; i < dy.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph[0].length) {
                if (mine[nextY][nextX]) {
//                    System.out.print(y + " " + x + " ");
//                    System.out.println(nextY + " " + nextX);
                    count++;
                }
            }

        }
        return count;
    }

}
