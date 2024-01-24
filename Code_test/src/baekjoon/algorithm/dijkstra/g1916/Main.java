package baekjoon.algorithm.dijkstra.g1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] D;
    static ArrayList<int[]>[] Graph;
    static boolean[] visit;
    static final long INF = 100_000_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        D = new long[N];
        Graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Graph[i] = new ArrayList<int[]>();
        }
        Arrays.fill(D, INF);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int price = Integer.parseInt(st.nextToken());
            Graph[A].add(new int[]{B, price});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int finish = Integer.parseInt(st.nextToken()) - 1;

        D[start] = 0;
        find(start, finish);

        System.out.println(D[finish]);
    }

    static void find(int start, int finish){
        int minIndex = -1;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < Graph[start].size(); i++) {
            int[] tmp = Graph[start].get(i);
            int next = tmp[0];
            int pay = tmp[1];
            if (!visit[next]) {
                D[next] = D[start] + pay < D[next] ? D[start] + pay : D[next];
            }
        }
        visit[start] = true;
//        System.out.println(start + " " + finish + Arrays.toString(D));
        if (start == finish) {
            return;
        }
        for (int i = 0; i < D.length; i++) {
            if(!visit[i] && min >= D[i]){
                min = D[i];
                minIndex = i;
            }
        }
        find(minIndex, finish);
    }

}
