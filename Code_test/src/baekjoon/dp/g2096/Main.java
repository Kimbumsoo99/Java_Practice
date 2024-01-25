package baekjoon.dp.g2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int[][] maxDp;
    static int[][] minDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][3];
        maxDp = new int[N][3];
        minDp = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A1 = Integer.parseInt(st.nextToken());
            int A2 = Integer.parseInt(st.nextToken());
            int A3 = Integer.parseInt(st.nextToken());
            Graph[i][0] = A1;
            Graph[i][1] = A2;
            Graph[i][2] = A3;
        }

        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = Graph[0][i];
            minDp[0][i] = Graph[0][i];
        }
        for (int i = 1; i < N; i++) {
            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + Graph[i][0];
            maxDp[i][1] = Math.max(maxDp[i-1][0], Math.max(maxDp[i-1][1], maxDp[i-1][2])) + Graph[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + Graph[i][2];
            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + Graph[i][0];
            minDp[i][1] = Math.min(minDp[i-1][0], Math.min(minDp[i-1][1], minDp[i-1][2])) + Graph[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + Graph[i][2];
        }

        System.out.println(Math.max(maxDp[N - 1][0], Math.max(maxDp[N - 1][1], maxDp[N - 1][2])));
        System.out.println(Math.min(minDp[N - 1][0], Math.min(minDp[N - 1][1], minDp[N - 1][2])));
    }

}
