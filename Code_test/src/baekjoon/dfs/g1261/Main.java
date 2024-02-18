package baekjoon.dfs.g1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Graph[][], count = Integer.MAX_VALUE;
    static int[] dx = new int[]{0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[N + M][N][M];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = arr[j] - '0';
            }
        }
//        bfs();
        dijkstra();
        System.out.println(count);
    }

    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        visit[0][0][0] = true;
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int tmp[] = pq.poll();
            if (tmp[0] == N - 1 && tmp[1] == M - 1) {
                count = Math.min(count, tmp[2]);
                continue;
            } else if (tmp[2] >= count) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX) && !visit[0][nextY][nextX]) {
                    visit[0][nextY][nextX] = true;
                    if (Graph[nextY][nextX] == 1) {
                        pq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                    } else {
                        pq.offer(new int[]{nextY, nextX, tmp[2]});
                    }
                }
            }
        }
    }

    static void bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visit[0][0][0] = true;
        dq.offer(new int[]{0, 0, 0});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
//            System.out.println(Arrays.toString(tmp));
            if (tmp[0] == N - 1 && tmp[1] == M - 1) {
                count = Math.min(count, tmp[2]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    if (!visit[tmp[2]][nextY][nextX] && Graph[nextY][nextX] == 0) {
                        dq.offer(new int[]{nextY, nextX, tmp[2]});
                        visit[tmp[2]][nextY][nextX] = true;
                    }
                    if (tmp[2] + 1 < visit.length && !visit[tmp[2] + 1][nextY][nextX]
                        && Graph[nextY][nextX] == 1) {
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[tmp[2] + 1][nextY][nextX] = true;
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
