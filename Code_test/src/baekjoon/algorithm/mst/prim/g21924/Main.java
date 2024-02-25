package baekjoon.algorithm.mst.prim.g21924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
    int no, weight;

    public Node(int no, int weight) {
        this.no = no;
        this.weight = weight;
    }
}
public class Main {
    static ArrayList<int[]>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도로
        lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken()); // 간선
        long maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            maxWeight += C;
            lists[A].add(new int[]{B, C});
            lists[B].add(new int[]{A, C});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        int cnt = 0;
        long weight = 0;
        int[] cost = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;
        pq.offer(new Node(1, cost[1]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visit[current.no]) {
                continue;
            }
            if (cnt++ == N) {
                break;
            }
            visit[current.no] = true;
            weight += current.weight;
//            System.out.println("weight = " + weight + " current : " + current.no);
            for (int[] next : lists[current.no]) {
                if (!visit[next[0]] && cost[next[0]] > next[1]) {
//                    System.out.println("current : " + current.no + " -> next : " + next[0]);
                    cost[next[0]] = next[1];
                    pq.offer(new Node(next[0], cost[next[0]]));
                }
            }
        }

        System.out.println(cnt == N ? (maxWeight - weight) : -1);
    }
}
