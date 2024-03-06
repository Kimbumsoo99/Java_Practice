package baekjoon.algorithm.mst.prim.g14621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int no, weight;

    public Node(int no, int weight) {
        super();
        this.no = no;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static boolean[] gender;
    static ArrayList<int[]>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        gender = new boolean[N + 1];
        nodeList = new ArrayList[N + 1];
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
            char s = st.nextToken().charAt(0);
            gender[i] = s == 'M' ? true : false;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            nodeList[A].add(new int[] { B, C });
            nodeList[B].add(new int[] { A, C });
        }

        int[] cost = new int[N + 1];
        Arrays.fill(cost, 987654321);
        boolean[] visit = new boolean[N + 1];
        cost[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Node(1, cost[1]));
        int cnt = 0;
        int weight = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (visit[tmp.no])
                continue;
            if (cnt++ == N)
                break;
            weight += tmp.weight;
            visit[tmp.no] = true;
            for (int[] next : nodeList[tmp.no]) {
                if (!visit[next[0]] && cost[next[0]] > next[1] && gender[tmp.no] != gender[next[0]]) {
                    cost[next[0]] = next[1];
//					System.out.println(Arrays.toString(next));
                    pq.offer(new Node(next[0], cost[next[0]]));
                }
            }
        }
        System.out.println(cnt == N ? weight : -1);
    }
}
