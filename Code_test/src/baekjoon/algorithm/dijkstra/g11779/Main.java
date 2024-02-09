package baekjoon.algorithm.dijkstra.g11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Node>> Graph;
    static int[] cost;
    static Node[] route;
    static final int INF = 987_654_321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Graph = new ArrayList<>();
        route = new Node[N + 1];
        cost = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            Graph.add(new ArrayList<>());
            route[i] = new Node(i, 0);
        }
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            Graph.get(A).add(new Node(B, C));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        dijkstra(start, finish);
        System.out.println(cost[finish]);
        StringBuilder sb = new StringBuilder();
        int current = finish;
        int count = 0;
//        System.out.println("route " + Arrays.toString(route));
        ArrayList<Integer> routing = new ArrayList<>();
        while (current != 0) {
//            System.out.println(current);
            routing.add(current);
            current = route[current].pre;
            count++;
        }
        System.out.println(count);
        for (int i = routing.size() - 1; i >= 0; i--) {
            sb.append(routing.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void dijkstra(int start, int finish) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        pq.offer(new Node(start, 0));
        Arrays.fill(cost, INF);
        cost[start] = 0;
        route[start].pre = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
//            System.out.println(tmp);
            if(tmp.val > cost[finish]) continue;
            for (Node next : Graph.get(tmp.end)) {
                if (cost[next.end] > cost[tmp.end] + next.val) {
                    cost[next.end] = cost[tmp.end] + next.val;
//                    System.out.println(Arrays.toString(cost));
//                    System.out.println("NEXT " + next);
                    route[next.end].pre = tmp.end;
//                    System.out.println(next.end + " " + route[next.end].pre + " " + tmp.end);
                    pq.offer(new Node(next.end, tmp.val + next.val));
                }
            }
        }
    }
}
class Node{
    int end;
    int val;
    int pre;
    Node(){}
    Node(int end, int val) {
        this.end = end;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "end=" + end +
                ", val=" + val +
                ", pre=" + pre +
                '}';
    }
}

