package baekjoon.implementations.silver.sum_rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] Graph = new int[101][101];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    Graph[j][k] = 1;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph.length; j++) {
                if (Graph[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void draw(int[][] Graph){
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph.length; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
