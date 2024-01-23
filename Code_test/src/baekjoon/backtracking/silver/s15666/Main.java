package baekjoon.backtracking.silver.s15666;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static HashSet<String> set = new HashSet<>();
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
            S[i] = sc.nextInt();
        }
        Arrays.sort(S);
        for (int i = 0; i < N; i++) {
            recur(i ,S[i], N, 1);
        }
        System.out.println(sb);
    }

    static void recur(int idx, int add, int N, int depth) {
        arr[depth - 1] = add;
        if (depth == arr.length) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                tmp.append(arr[i]).append(" ");
            }
            tmp.append("\n");
            if (!set.contains(tmp.toString())) {
                set.add(tmp.toString());
                sb.append(tmp);
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            recur(i, S[i], N, depth + 1);
        }
    }
}
