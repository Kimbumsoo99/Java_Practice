package baekjoon.algorithm.sum.s29718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M], sum = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                sum[i][j] = i > 0 ? sum[i - 1][j] + tmp : tmp;
            }
        }

        int A = Integer.parseInt(br.readLine());

        int pre = 0;
        int max;
        for (int i = 0; i < A; i++) {
            pre += sum[N - 1][i];
        }
        max = pre;

        for (int i = A; i < M; i++) {
            pre = pre - sum[N - 1][i - A] + sum[N - 1][i];
            max = Math.max(max, pre);
        }
        System.out.println(max);
    }
}
