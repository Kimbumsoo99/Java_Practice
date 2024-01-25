package baekjoon.algorithm.dijkstra.g4485;

// 녹색 옷 입은 애가 젤다지?
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int[][] cost;
    static int[] dx = new int[] { 0, 1, 0, -1 };
    static int[] dy = new int[] { 1, 0, -1, 0 };
    static boolean[][] visit;
    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.println(sb);
                return;
            }
            cost = new int[N][N];
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(cost[i], INF);
            }
            Graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra(0, 0);
            sb.append("Problem ").append(T++).append(": ").append(cost[N - 1][N - 1]).append("\n");
        }
    }

    static void dijkstra(int y, int x) {
        cost[y][x] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        pq.offer(new int[] { y, x, Graph[y][x], y, x }); // 현재 yx, cost, 이전 yx
//		int count = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int cY = tmp[0];
            int cX = tmp[1];
            int c = tmp[2]; // cost
            for (int i = 0; i < 4; i++) {
                int nextY = cY + dy[i];
                int nextX = cX + dx[i];
                if (!(nextY == tmp[3] && nextX == tmp[4]) && nextY >= 0 && nextX >= 0 && nextY < Graph.length
                    && nextX < Graph.length) {
                    if (cost[nextY][nextX] > c + Graph[nextY][nextX]) {
                        cost[nextY][nextX] = c + Graph[nextY][nextX];
                        pq.offer(new int[] { nextY, nextX, cost[nextY][nextX], cY, cX });
                    }
                }
            }
        }

    }
}
