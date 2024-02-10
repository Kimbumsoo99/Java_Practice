package baekjoon.algorithm.floyd_warshall.g1238;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] Graph;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(Graph[i], INF);
            Graph[i][i] = 0;
        }
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());
            Graph[A][B] = C;
        }
        for (int current = 0; current < N; current++) {
            for (int i = 0; i < N; i++) {
                if(i==current) continue;
                for (int j = 0; j < N; j++) {
                    if(i==j) continue;
                    Graph[i][j] = Math.min(Graph[i][j], Graph[i][current] + Graph[current][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, Graph[i][X] + Graph[X][i]);
        }
        System.out.println(max);
    }
}
