package baekjoon.algorithm.dijkstra.g5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] D;
    static final int INF = 100_000_000;
    static ArrayList<int[]>[] Graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Graph[i] = new ArrayList<int[]>();
        }
        D = new int[N];
        visit = new boolean[N];
        Arrays.fill(D, INF);
        D[0] = 0;
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int cow = Integer.parseInt(st.nextToken());
            Graph[A].add(new int[]{B, cow});
            Graph[B].add(new int[]{A, cow});
        }

//        find(0, N - 1);
        findByPriorityQueue(0, N - 1);
        System.out.println(D[N - 1]);
    }


    // PriorityQueue를 사용해서 했을 때 시간이 남았음.
    private static void findByPriorityQueue(int start, int finish) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        D[start] = 0;

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            for (int[] next : Graph[tmp[0]]) {
                if (D[next[0]] > D[tmp[0]] + next[1]) {
                    D[next[0]] = D[tmp[0]] + next[1];
                    pq.offer(new int[]{next[0], D[next[0]]});
                }
            }
        }
    }

    // 그냥 모든 것에 대하여, 탐색을 하는 경우 시간 초과가 발생
    static void find(int current, int finish){
        for (int i = 0; i < Graph[current].size(); i++) {
            int[] tmp = (int[]) Graph[current].get(i);
            int next = tmp[0];
            int cow = tmp[1];
            if (!visit[next]) {
                D[next] = D[current] + cow < D[next] ? D[current] + cow : D[next];
            }
        }

        visit[current] = true;
        if (current == finish) {
            return;
        }

        int minIdx = -1;
        long minValue = Long.MAX_VALUE;
        for (int i = 0; i < D.length; i++) {
            if (!visit[i] && minValue > D[i]) {
                minIdx = i;
                minValue = D[i];
            }
        }
        find(minIdx, finish);
    }

}
