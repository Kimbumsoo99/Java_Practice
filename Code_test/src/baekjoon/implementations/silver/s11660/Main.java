package baekjoon.implementations.silver.s11660;

import java.util.Scanner;

// 구간 합 구하기 5, 알고리즘 코테 풀이 문제
public class Main {
    static int[][] A;
    static int[][] S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        S = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];
        int M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int tmp = sc.nextInt();
                A[i][j] = tmp;
                S[i][j] = S[i - 1][j] + S[i][j - 1] + A[i][j] - S[i - 1][j - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int Ax = sc.nextInt();
            int By = sc.nextInt();
            int Cx = sc.nextInt();
            int Dy = sc.nextInt();
            sb.append(S[Cx][Dy] - S[Ax - 1][Dy] - S[Cx][By - 1] + S[Ax - 1][By - 1]).append("\n");
        }
        System.out.println(sb);
    }

}
