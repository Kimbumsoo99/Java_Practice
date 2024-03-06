package baekjoon.algorithm.mst.prim.g1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
    int next, weight;
    Node(int next, int weight){
        this.next = next;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
            "next=" + next +
            ", weight=" + weight +
            '}';
    }
}
public class Main {
    static int cost[];
    static ArrayList<Node>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        cost = new int[N+1];
        nodes = new ArrayList[N + 1];
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N+1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            nodes[A].add(new Node(B, C));
            nodes[B].add(new Node(A, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        Arrays.fill(cost, Integer.MAX_VALUE);
        boolean[] visit = new boolean[N + 1];
        cost[1] = 0;
        int cnt = 0;
        pq.offer(new Node(1, cost[1]));
        int weight = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
//            System.out.println(Arrays.toString(cost));
//            System.out.println(cur);
            if (visit[cur.next]) {
                continue;
            }
            if (cnt++ == N) {
                break;
            }
            visit[cur.next] = true;
            weight += cur.weight;
            max = Math.max(max, cur.weight);
            for (Node next : nodes[cur.next]) {
                if (!visit[next.next] && cost[next.next] > next.weight) {
                    cost[next.next] = next.weight;
                    pq.offer(new Node(next.next, cost[next.next]));
                }
            }
        }
        System.out.println(weight - max);
    }
}
