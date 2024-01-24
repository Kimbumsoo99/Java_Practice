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
        pq.offer(new int[]{start, 0}); // start를 PQ에 넣음
        D[start] = 0; // start를 제외한 모든 지역은 INF

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            // 현재 선택된 Node
            int choice = tmp[0];
            int cow = tmp[1];

            // Node와 간선으로 연결된 `chain` 확인
            for (int[] chain : Graph[choice]) {
                // 각 경로에 대하여 최솟값 저장 D[chain[0]] = Math.min(D[choice] + chain[1], D[chain[0]]);
                // -> 연결된 노드에 대하여, Node 경유 + 연결 노드에 cow와 이미 저장된 경로 값 비교
                // 만약, 기존 값 (INF)보다 작은 경우, 값을 바꾸고, PQ에 경로와 값 추가
                if (D[chain[0]] > D[choice] + chain[1]) {
                    D[chain[0]] = D[choice] + chain[1];
                    pq.offer(new int[]{chain[0], D[chain[0]]});
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
