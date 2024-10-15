package baekjoon.comb.n_m.s15650;

import java.util.Scanner;

public class Main {
    static int arr[];
    static int s[];
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        visit = new boolean[N];
        s = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        comb(0, 0);
//		perm(0);
        System.out.println(sb);
    }
    static void comb(int cur, int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = cur; i < N; i++) {
            s[depth] = arr[i];
            comb(i+1, depth + 1);
        }

    }

    static void perm(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                s[depth] = arr[i];
                perm(depth+1);
                visit[i] = false;
            }
        }

    }
}
