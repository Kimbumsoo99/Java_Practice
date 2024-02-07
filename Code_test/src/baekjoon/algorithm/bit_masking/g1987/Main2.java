package baekjoon.algorithm.bit_masking.g1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사실 비트마스킹은 아님, bfs + 비트마스킹 풀이
public class Main2 {
    static char Graph[][];
    static boolean[][] visit;
    static int N, M, answer = 0;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static final int BIN = (int) Math.pow(2, 26) - 1;
    static int mask = BIN;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            Graph[i] = br.readLine().toCharArray();
        }
        mask = BIN - (1 << (Graph[0][0] - 'A'));
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int y, int x, int count) {
        System.out.println(Graph[y][x] + " " + count);
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (isMap(nextY, nextX)) {
                if ((mask & (1 << (Graph[nextY][nextX] - 'A'))) != 0) {
                    mask = mask - (1 << (Graph[nextY][nextX] - 'A'));
                    dfs(nextY, nextX, count + 1);
                    mask = mask + (1 << (Graph[nextY][nextX] - 'A'));
                }
            }
        }
        answer = Math.max(answer, count);
    }
    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }
}
