package baekjoon.algorithm.dijkstra.g10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int next, time;

    public Node(int next, int time) {
        super();
        this.next = next;
        this.time = time;
    }

}

public class Main {
    static int cost[], N;
    static ArrayList<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점
            lists = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                lists[i] = new ArrayList<>();
            }
            int d = Integer.parseInt(st.nextToken()); // 간선
            int c = Integer.parseInt(st.nextToken()); // 시작점
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                lists[B].add(new Node(A, C));
            }
            dijkstra(c);
        }
    }

    static void dijkstra(int start) {
        cost = new int[N + 1];
        Arrays.fill(cost, 987654321); // INF
        cost[start] = 0;
        int last = start;
        PriorityQueue<Node> pQueue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        pQueue.offer(new Node(start, cost[start]));
        while (!pQueue.isEmpty()) {
            Node cur = pQueue.poll();
            for (Node next : lists[cur.next]) {
                if (cost[next.next] > cur.time + next.time) {
                    cost[next.next] = cur.time + next.time;
                    pQueue.offer(new Node(next.next, cost[next.next]));
                    last = next.next;
                }
            }
        }

        int cnt = 0, time = 0;
        for (int i = 0; i < N + 1; i++) {
            if (cost[i] != 987654321) {
                time = Math.max(time, cost[i]);
                cnt++;
            }
        }
        System.out.println(cnt + " " + time);
    }
}
