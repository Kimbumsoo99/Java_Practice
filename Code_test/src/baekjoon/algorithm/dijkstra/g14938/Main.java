package baekjoon.algorithm.dijkstra.g14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, Graph[][], arr[], answer = 0, cost[];
    static ArrayList<int[]>[] list;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        cost = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new int[] { B, C });
            list[B].add(new int[] { A, C });
        }
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(cost, INF);
            answer = Math.max(answer, dijkstra(i));
        }
        System.out.println(answer);
    }

    // 즉, start 위치에서 다른 위치로 가는 최선의 길이를 구한 뒤
    // 이게 M보다 작다면, 숫자를 더하는 방식
    static int dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        cost[start] = 0;
        pq.offer(new int[] { start, 0 }); // 시작점에서 시작점은 0만큼 가중치
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            for (int[] next : list[tmp[0]]) {
                if (cost[next[0]] > cost[tmp[0]] + next[1]) {
                    cost[next[0]] = cost[tmp[0]] + next[1];
                    pq.offer(new int[] { next[0], tmp[1] + next[1] });
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            if (cost[i] <= M) {
                sum += arr[i];
            }
        }
        return sum;
    }

}
