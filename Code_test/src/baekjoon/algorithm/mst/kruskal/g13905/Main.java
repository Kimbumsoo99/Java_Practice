package baekjoon.algorithm.mst.kruskal.g13905;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return o.weight - this.weight;
        }

    }

    static int N, M, A, B, C, s, e;
    static int[] parents;
    static Edge[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        edgeList = new Edge[M];

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(A, B, C);
        }
        make();
        Arrays.sort(edgeList);
        int res = 0;
        for (int i = 0; i < edgeList.length; i++) {
            union(find(edgeList[i].start), find(edgeList[i].end));
            res = edgeList[i].weight;
            if (find(s) == find(e))
                break;

        }
        if (parents[s] != parents[e])
            res = 0;
        System.out.println(res);
    }

    public static void make() {
        for (int i = 0; i <= N; i++)
            parents[i] = i;
    }

    public static void union(int p, int x) {
        if (p == x)
            return;
        parents[x] = p;
    }

    public static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

}
