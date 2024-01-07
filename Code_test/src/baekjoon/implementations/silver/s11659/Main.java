package baekjoon.implementations.silver.s11659;

import java.util.Scanner;

// 구간합 구하기, 알고리즘 코딩테스트 책 내용
public class Main {
    static int S[];
    static int A[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        S = new int[N];
        int M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            A[i] = tmp;
            if (i == 0) {
                S[i] = A[i];
            } else {
                S[i] = S[i - 1] + A[i];
            }
        }
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt() - 2;
            int B = sc.nextInt() - 1;
            if (A == -1) {
                System.out.println(S[B]);
            } else {
                System.out.println(S[B] - S[A]);
            }
        }
    }

}
