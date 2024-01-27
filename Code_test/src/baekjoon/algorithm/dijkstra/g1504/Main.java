package baekjoon.algorithm.dijkstra.g1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]>[] Graph;
    static final int INF = 100_000_000;
    static boolean[] visit;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N + 1];
        cost = new int[N + 1];
        visit = new boolean[N + 1];
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            Graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            Graph[A].add(new int[]{B, C});
            Graph[B].add(new int[]{A, C});
        }
        st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        Arrays.fill(cost, INF);
        int A = dijkstra(1, N1);
        Arrays.fill(cost, INF);
        int B = dijkstra(N1, N2);
        Arrays.fill(cost, INF);
        int C = dijkstra(N2, N);


        Arrays.fill(cost, INF);
        int D = dijkstra(1, N2);
        Arrays.fill(cost, INF);
        int E = dijkstra(N2, N1);
        Arrays.fill(cost, INF);
        int F = dijkstra(N1, N);
//        System.out.println(Arrays.toString(cost));
        long answer = Math.min(A + B + C, D + E + F);
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static int dijkstra(int start, int node){
        cost[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            for (int[] next : Graph[current[0]]) {
                if (cost[next[0]] > next[1] + cost[current[0]]) {
                    cost[next[0]] = next[1] + cost[current[0]];
                    pq.offer(new int[]{next[0], cost[next[0]]});
                }
            }
        }
        return cost[node];
    }
}
