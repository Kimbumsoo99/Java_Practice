package baekjoon.data_structure.tree.g1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int idx, parent;
    ArrayList<Node> child = new ArrayList<>();

    @Override
    public String toString() {
        return "Node{" +
                "idx=" + idx +
                ", child=" + child +
                '}';
    }
}
public class Main {
    static int N, leafNode;
    static Node[] nodes;
    static boolean[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }
        p = new boolean[N];
        Node head = null;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            nodes[i].idx = i;
            leafNode++;
            if (a == -1) {
                head = nodes[i];
                continue;
            }
            nodes[a].child.add(nodes[i]);
            nodes[i].parent = a;
            if (!p[a]) {
                p[a] = true;
                leafNode--;
            }
        }
        // node 삭제 -> 탐색하며 leafNode 지우기
        int r = Integer.parseInt(br.readLine());
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(nodes[r]);
        if (r != head.idx && nodes[nodes[r].parent].child.size() == 1) {
            leafNode++;
        }
        while (!dq.isEmpty()) {
            Node tmp = dq.pollFirst();

            if (!p[tmp.idx]) {
                p[tmp.idx] = true;
                leafNode--;
            }
            for (Node node : tmp.child) {
                dq.offer(node);
            }
        }
        System.out.println(leafNode);


    }
}
