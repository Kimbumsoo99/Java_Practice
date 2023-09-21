package baekjoon.implementations.silver.s10709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기상캐스터, 10709번, 실버 V
public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int Y, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Graph = new int[Y][X];
        visit = new boolean[Y][X];
        for (int i = 0; i < Y; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                String tmp = str[j];
                Graph[i][j] = -1;
                if (tmp.equals("c")) {
                    visit[i][j] = true;
                    Graph[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= X; i++) {
            rightCloud(i);
        }

        // draw
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                sb.append(Graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rightCloud(int count) {
        for (int i = X - 1; i > 0; i--) {
            for (int j = 0; j < Y; j++) {
                if (visit[j][i - 1] && Graph[j][i] == -1) {
                    Graph[j][i] = count;
                    visit[j][i] = true;
                    visit[j][i - 1] = false;
                } else if (visit[j][i - 1] && Graph[j][i] != -1) {
                    visit[j][i - 1] = false;
                }
            }
        }
    }
}
