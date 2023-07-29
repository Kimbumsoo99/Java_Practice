package baekjoon.implementations.silver.two_level_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버 V, 2167번, 2차원 배열의 합
public class Main {

    static int[][] Graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        Graph = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int sum = getSum(i - 1, j - 1, y, x);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static int getSum(int i, int j, int y, int x) {
        int sum = 0;
//        for (int k = i; k < y; k++) {
//            for (int l = 0; l < Graph[0].length; l++) {
//                if ((k == i && l < j) || (k == y - 1 && l >= x)) {
//                    continue;
//                }
//                sum += Graph[k][l];
//            }
//        }
        for (int k = i; k < y; k++) {
            for (int l = j; l < x; l++) {
                sum += Graph[k][l];
            }
        }
        return sum;
    }
}
