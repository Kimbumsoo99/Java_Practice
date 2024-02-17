package baekjoon.dfs.g1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N, M, Graph[][], answer = 0, bitVisited[][];
    static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
    static boolean[] visit = new boolean[26]; // 0 ~ 25

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        bitVisited = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = arr[j] - 'A';
            }
        }
        visit[Graph[0][0]] = true;
        bitVisited[0][0] = 1 << Graph[0][0];
        dfs(0, 0, 1 << Graph[0][0], 1);
        System.out.println(answer);
    }

    static void dfs(int y, int x, int flag, int count) {

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (isMap(nextY, nextX) && !visit[Graph[nextY][nextX]]) {
                if (bitVisited[nextY][nextX] != (flag | (1 << Graph[nextY][nextX]))) {
                    bitVisited[nextY][nextX] = flag | (1 << Graph[nextY][nextX]);
                    visit[Graph[nextY][nextX]] = true;
                    dfs(nextY, nextX, bitVisited[nextY][nextX], count + 1);
                    visit[Graph[nextY][nextX]] = false;
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
