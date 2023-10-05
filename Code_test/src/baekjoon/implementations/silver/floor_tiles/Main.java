package baekjoon.implementations.silver.floor_tiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1388번, 바닥 장식, 실버 IV
public class Main {

    static boolean visit[][];
    static char[][] Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        Graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = tmp.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    answer++;
                    countTile(i, j, Graph[i][j]);
//                    System.out.println();
                }
            }
        }
        System.out.println(answer);
    }

    private static void countTile(int y, int x, char tile) {
//        System.out.print(y + " " + x + " | ");
        visit[y][x] = true;
        int nextX = x;
        int nextY = y;
        if (tile == '-') {
            nextX++;
        } else {
            nextY++;
        }
        if (nextY < Graph.length && nextX < Graph[0].length) {
            if (!visit[nextY][nextX] && Graph[nextY][nextX] == tile) {
                countTile(nextY, nextX, tile);
            }
        }
    }
}
