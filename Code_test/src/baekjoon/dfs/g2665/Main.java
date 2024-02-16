package baekjoon.dfs.g2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int N, Graph[][];
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                Graph[i][j] = arr[j] - '0';
            }
        }
        int maxWhite = 2 * (N - 1);

        System.out.println(bfs(maxWhite));
    }

    static int bfs(int max) {
        int count = Integer.MAX_VALUE;
        boolean visit[][][] = new boolean[max][N][N];
        visit[0][0][0] = true;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] { 0, 0, 0 });

        while (!deque.isEmpty()) {
            int[] tmp = deque.pollFirst();
            if (tmp[0] == N - 1 && tmp[1] == N - 1) {
                count = Math.min(count, tmp[2]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    if (!visit[tmp[2]][nextY][nextX] && Graph[nextY][nextX] == 1) {
                        deque.offer(new int[] { nextY, nextX, tmp[2] });
                        visit[tmp[2]][nextY][nextX] = true;
                    }
                    if (Graph[nextY][nextX] == 0 && tmp[2] + 1 < max && !visit[tmp[2] + 1][nextY][nextX]) {
                        deque.offer(new int[] { nextY, nextX, tmp[2] + 1 });
                        visit[tmp[2] + 1][nextY][nextX] = true;
                    }
                }
            }
        }

        return count;
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < N) {
            return true;
        }
        return false;
    }
}
