package baekjoon.algorithm.mst.kruskal.g1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        super();
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    static Edge[] edgeList;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 정점
        int M = Integer.parseInt(br.readLine()); // 간선
        edgeList = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(A, B, C);
        }
        Arrays.sort(edgeList);
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }

        long weight = 0;
        int count = 0;
        for (int i = 0; i < M; i++) {
            int A = edgeList[i].from;
            int B = edgeList[i].to;
            int C = edgeList[i].weight;
//				System.out.println(A + " " + B + " " + C);
            if (union(find(A), find(B))) {
                weight += C;
                if (++count == N - 1)
                    break;
            }
        }
        System.out.println(weight);
    }

    static boolean union(int p, int x) {
        if (p == x)
            return false;
        parents[x] = p;
        return true;
    }

    static int find(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }
}
