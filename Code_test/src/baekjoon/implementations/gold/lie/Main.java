package baekjoon.implementations.gold.lie;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> know = new ArrayList<>();
    static int[][] Graph;
    static boolean[] visit;
    static int[][] party;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        party = new int[M][N + 1];
        Graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            know.add(sc.nextInt());
            visit[know.get(i)] = true;
        }

        for (int i = 0; i < M; i++) {
            int L = sc.nextInt();
            party[i][0] = L;
            int A = sc.nextInt();
            party[i][1] = A;
            if (L == 1) {
                continue;
            }
            for (int j = 0; j < L - 1; j++) {
                int B = sc.nextInt();
                party[i][j + 2] = B;
                Graph[A][B] = Graph[B][A] = 1;
            }
        }

        for (Integer known : know) {
            bfs(known, N);
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(Graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        HashSet<Integer> unknown = new HashSet<>();
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                unknown.add(i);
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= party[i][0]; j++) {
                if (unknown.contains(party[i][j])) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int known, int N) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(known);
        while (!dq.isEmpty()) {
            int tmp = dq.pollFirst();
            for (int i = 1; i < N + 1; i++) {
                if (tmp == i) {
                    continue;
                }
                if (!visit[i] && Graph[tmp][i] == 1) {
                    dq.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

}
