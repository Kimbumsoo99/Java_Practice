package baekjoon.backtracking.silver.s15663;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 좀 어렵게 풀음, N과 M 시리즈중 (9)
public class Main {

    static int arr[];
    static int[] S;
    static boolean[] visit;
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
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            if (!set.contains(S[i])) {
                set.add(S[i]);
                recur(S[i], N, 1);
            }
            visit[i] = false;
        }
        System.out.println(sb);
    }
    static void recur(int add, int N, int depth){
        arr[depth - 1] = add;
        if (depth == arr.length) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (!set.contains(S[i])) {
                    set.add(S[i]);
                    recur(S[i], N, depth + 1);
                }
                visit[i] = false;
            }
        }
    }
}
