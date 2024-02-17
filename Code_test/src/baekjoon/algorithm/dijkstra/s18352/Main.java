package baekjoon.algorithm.dijkstra.s18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, X, cost[];
    static ArrayList<Integer>[] Graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N + 1];
        cost = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            Graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
//            System.out.println(A + " " + B);
            Graph[A].add(B);
        }
        ArrayList<Integer> ans = dijkstra(X);
        if (ans.isEmpty()) {
            System.out.println(-1);
        }
        for (int answer : ans) {
            System.out.println(answer);
        }
    }

    static ArrayList<Integer> dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        Arrays.fill(cost, 987654321);
        cost[start] = -1;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            for (int next : Graph[tmp[0]]) {
                if (cost[next] > 1 + tmp[1]) {
                    cost[next] = 1 + tmp[1];
                    pq.offer(new int[]{next, cost[next]});
                }
            }
        }

        ArrayList<Integer> returnList = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (cost[i] == K) {
                returnList.add(i);
            }
        }
        return returnList;
    }
}
