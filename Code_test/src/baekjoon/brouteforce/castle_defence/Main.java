package baekjoon.brouteforce.castle_defence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int range = 0;
    static int[][] Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        draw();
        nextRound();
        draw();
        nextRound();
        draw();
        nextRound();
        draw();
        nextRound();
        draw();
    }

    static void nextRound(){
        for (int i = Graph.length - 1; i > 1; i--) {
            System.out.println(i);
            Graph[i] = Graph[i - 1];
        }
        draw();
        for (int i = 0; i < Graph[0].length; i++) {
            Graph[0][i] = 0;
        }
    }

    static void draw(){
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph[0].length; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
