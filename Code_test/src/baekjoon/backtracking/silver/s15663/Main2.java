package baekjoon.backtracking.silver.s15663;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 좀 어렵게 풀음, N과 M 시리즈중 (9)
public class Main2 {
    static int arr[];
    static int[] S;
    static boolean[] visit;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        S = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            S[i] = sc.nextInt();
        }
        Arrays.sort(S);
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            recur(S[i], N, 1);
            visit[i] = false;
        }
        System.out.println(sb);
    }

    static void recur(int add, int N, int depth) {
        arr[depth - 1] = add;
        if (depth == arr.length) {
            StringBuilder tempBuilder = new StringBuilder();
            for (int i : arr) {
                tempBuilder.append(i).append(" ");
            }
            tempBuilder.append("\n");

            if (!set.contains(tempBuilder.toString())) {
                set.add(tempBuilder.toString());
                sb.append(tempBuilder);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recur(S[i], N, depth + 1);
                visit[i] = false;
            }
        }
    }
}

