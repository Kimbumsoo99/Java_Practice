package baekjoon.dfs.g14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[][][] visit;
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static final int INF = 100_000_000;
    static int N, M, K, answer = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[K + 1][N][M];
        for (int i = 0; i < N; i++) {
            Graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        bfs();
        System.out.println(answer == INF ? -1 : answer);
    }

    static void bfs(){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0, 0, 1});
        visit[0][0][0] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (tmp[0] == N - 1 && tmp[1] == M - 1) {
                answer = Math.min(answer, tmp[3]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    if (!visit[tmp[2]][nextY][nextX] && Graph[nextY][nextX] == 0) {
                        visit[tmp[2]][nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2], tmp[3] + 1});
                    } else if (Graph[nextY][nextX] == 1 && K >= tmp[2] + 1
                        && !visit[tmp[2] + 1][nextY][nextX]) {
                        visit[tmp[2] + 1][nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1, tmp[3] + 1});
                    }
                }
            }
        }
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }

}
