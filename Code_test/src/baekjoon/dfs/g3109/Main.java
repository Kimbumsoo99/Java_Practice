package baekjoon.dfs.g3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1xx.1
.1x1.
..1..
...x.
...x.
 */
public class Main {
    static int N, M, Graph[][], count = 0;
    static int[] dx = new int[] { 1, 1, 1 }, dy = { -1, 0, 1 };
    static boolean[][] visit;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = cArr[j] == '.' ? 0 : 1;
            }
        }

        for (int i = 0; i < N; i++) {
            flag = false;
            dfs(i, 0);
        }

        System.out.println(count);
    }

    static void dfs(int y, int x) {
        if (flag)
            return;
        if (x == M - 1) {
            count++;
            flag = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (flag)
                return;
            if (isMap(nextY, nextX) && Graph[nextY][nextX] == 0 && !visit[nextY][nextX]) {
                visit[nextY][nextX] = true;
                Graph[nextY][nextX] = 2;
                dfs(nextY, nextX);
            }
        }
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x < M && y < N) {
            return true;
        }
        return false;
    }
}
