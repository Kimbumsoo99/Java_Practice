package baekjoon.backtracking.silver.s15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] S;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        S = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            S[i] = tmp;
        }
        Arrays.sort(S);
        for (int i = 0; i < N; i++) {
            recur(i, S[i], N, 1);
        }
        System.out.println(sb);
    }

    static void recur(int idx, int add, int N, int depth) {
        arr[depth - 1] = add;
        if (depth == arr.length) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < N; i++) {
            recur(i, S[i], N, depth + 1);
        }
    }
}
