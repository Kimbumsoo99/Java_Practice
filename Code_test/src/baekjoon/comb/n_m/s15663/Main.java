package baekjoon.comb.n_m.s15663;

import java.util.Arrays;
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

//		for (int i = 0; i < N; i++) {
//			arr[i] = i+1;
//		}
        set_arr(sc);

//		comb(0, 0);
        perm(0);
//		duplicated_perm(0);
//		duplicated_comb(0, 0);
        System.out.println(sb);
    }

    static void set_arr(Scanner sc) {
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
    }

    static void comb(int cur, int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = cur; i < N; i++) {
            s[depth] = arr[i];
            comb(i+1, depth + 1);
        }

    }

    static void duplicated_comb(int cur, int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = cur; i < N; i++) {
            s[depth] = arr[i];
            duplicated_comb(i, depth + 1);
        }
    }

    static void perm(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int pre = -1;
        for (int i = 0; i < N; i++) {
            if(!visit[i] && pre != arr[i]) {
                visit[i] = true;
                pre = arr[i];
                s[depth] = arr[i];
                perm(depth+1);
                visit[i] = false;
            }
        }
    }

    static void duplicated_perm(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0;i < N; i++) {
            s[depth] = arr[i];
            duplicated_perm(depth + 1);
        }
    }
}
