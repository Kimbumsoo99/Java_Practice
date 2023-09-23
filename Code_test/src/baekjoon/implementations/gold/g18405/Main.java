package baekjoon.implementations.gold.g18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경쟁적 전염, 골드 V, 18405번
public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int Y;
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Graph = new int[Y][X];
        visit = new boolean[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (Graph[i][j] != 0) {
                    visit[i][j] = true;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int findY = Integer.parseInt(st.nextToken()) - 1;
        int findX = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < time; i++) {
            spreadOne();
        }
    }
    static void spreadOne() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (!visit[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if (nextY >= 0 && nextX >= 0 && nextX < X && nextY < Y) {
                            if (!visit[nextY][nextX]) {
                                Graph[nextY][nextX] = Graph[i][j];
                                visit[nextY][nextX] = true;
                            }
                        }
                    }
                }
            }
        }
    }

}
