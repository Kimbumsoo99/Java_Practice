package baekjoon.algorithm.mst.kruskal.g4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Star{
    double y, x;

    public Star(double y, double x) {
        this.y = y;
        this.x = x;
    }
}
class Edge{
    int from, to;
    double weight;

    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    static int parents[], N;
    static double[][] map;
    static Star[] arr;
    static ArrayList<Edge> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        makeSet();
        arr = new Star[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            Star cur = arr[i];
            for (int j = i + 1; j < N; j++) {
                Star next = arr[j];
                list.add(new Edge(i, j, getWeight(cur, next)));
            }
        }
        Collections.sort(list, (o1, o2) -> Double.compare(o1.weight, o2.weight));

        int m = 0;
        double w = 0;
        for (Edge edge : list) {
            if (unionSet(findSet(edge.from), findSet(edge.to))) {
                w += edge.weight;
                if (++m == N - 1) {
                    break;
                }
            }
        }
        System.out.printf("%.2f", w);
    }
    static double getWeight(Star A, Star B){
        return Math.sqrt(Math.pow(A.y - B.y, 2) + Math.pow(A.x - B.x, 2));
    }

    static void makeSet(){
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
    }
    static boolean unionSet(int p, int x){
        if(p == x) return false;
        parents[x] = p;
        return true;
    }
    static int findSet(int x){
        if(parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }
}
