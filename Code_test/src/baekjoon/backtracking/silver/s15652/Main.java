package baekjoon.backtracking.silver.s15652;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        for (int i = 0; i < N; i++) {
            recur(i+1, N, 1);
        }
        System.out.println(sb);
    }

    static void recur(int add, int N, int depth) {
        arr[depth - 1] = add;
        if (depth == arr.length) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = add - 1; i < N; i++) {
            recur(i + 1, N, depth + 1);
        }
    }
}
