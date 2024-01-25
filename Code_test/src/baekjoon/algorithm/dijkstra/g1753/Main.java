package baekjoon.algorithm.dijkstra.g1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100_000_000;
    static ArrayList<int[]>[] Graph;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        cost = new int[N];
        Arrays.fill(cost, INF);
        Graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Graph[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            Graph[A].add(new int[] { B, c });
        }

        cost[K] = 0;
        dijkstra(K);
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(cost[i]);
            }
        }
    }

    static void dijkstra(int current) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.offer(new int[] { current, 0 });
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            // 현재 Graph에서 갈 수 있는 것 [0] - 위치, [1] - cost
            for (int[] canGo : Graph[tmp[0]]) {
                if (cost[canGo[0]] > cost[tmp[0]] + canGo[1]) {
                    cost[canGo[0]] = cost[tmp[0]] + canGo[1];
                    pq.offer(new int[] { canGo[0], cost[canGo[0]] });
                }
            }
        }
    }
}
