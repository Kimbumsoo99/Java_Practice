package baekjoon.data_structure.tree.g1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int maxLen = 0, maxIdx = -1;
    static Node[] trees;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        trees = new Node[V + 1];
        StringTokenizer st = null;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            trees[node] = new Node(node, 0);
            while (true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1)
                    break;
                int range = Integer.parseInt(st.nextToken());
                // 연결 처리
                trees[node].linked.add(new Node(tmp, range));
            }
        }
        visit = new boolean[V + 1];
        visit[1] = true;
        dfs(trees[1], 0);

        visit = new boolean[V + 1];
        visit[maxIdx] = true;
        dfs(trees[maxIdx], 0);
        System.out.println(maxLen);
    }

    static void dfs(Node current, int length) {
        if (length > maxLen) {
            maxLen = length;
            maxIdx = current.data;
        }
        for (Node next : current.linked) {
            if (!visit[next.data]) {
                visit[next.data] = true;
                dfs(trees[next.data], length + next.range);
            }
        }
    }
}

class Node {
    int data;
    int range;
    ArrayList<Node> linked = new ArrayList<>();

    Node(int data, int range) {
        this.data = data;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", range=" + range + ", linked=" + linked + "]";
    }

}

