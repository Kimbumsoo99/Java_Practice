package baekjoon.algorithm.floyd_warshall.g14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, answer = 0, Graph[][], arr[];
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Graph = new int[N + 1][N + 1];
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(Graph[i], INF);
            Graph[i][i] = 0;
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            Graph[A][B] = Graph[B][A] = C;
        }

        for (int current = 1; current < N + 1; current++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    Graph[i][j] = Math.min(Graph[i][j], Graph[i][current] + Graph[current][j]);
                }
            }
        }
//		for (int i = 1; i < N + 1; i++) {
//			System.out.println(Arrays.toString(Graph[i]));
//		}

        for (int i = 1; i < N + 1; i++) {
            int sum = 0;
            for (int j = 1; j < N + 1; j++) {
                if (Graph[i][j] <= M)
                    sum += arr[j];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
