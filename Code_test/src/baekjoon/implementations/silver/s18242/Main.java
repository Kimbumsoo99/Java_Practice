package baekjoon.implementations.silver.s18242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18242 번
public class Main {
    static int[][] Graph;

    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (tmp.charAt(j) == '#') {
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    Graph[i][j] = 1;
                }
            }
        }
        int length = maxY - minY + 1;
        String answer = "";
        for (int i = minX; i <= maxX; i++) {
            if (Graph[minY][i] == 0) {
                answer = "UP";
            } else if (Graph[maxY][i] == 0) {
                answer = "DOWN";
            }
        }
        for (int i = minY; i <= maxY; i++) {
            if (Graph[i][minX] == 0) {
                answer = "LEFT";
            } else if (Graph[i][maxX] == 0) {
                answer = "RIGHT";
            }
        }
        System.out.println(answer);

    }
}
