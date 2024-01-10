package baekjoon.solving.gold.floyd;

import java.util.*;

public class Fail {
    static int[][] Graph;
    static int[][] total;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Graph = new int[N][N];
        total = new int[N][N];
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt()-1;
            int B = sc.nextInt()-1;
            int cost = sc.nextInt();
//			System.out.println(A+" " +B+" " +cost);
            if(Graph[A][B] != 0 && cost > Graph[A][B]) continue;
            Graph[A][B] = cost;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total[i][j] = 100000;
            }
        }

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(Graph[i][j] +" ");
//			}
//			System.out.println();
//		}
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean visit[] = new boolean[N];
                visit[i] = true;
                dfs(i, i, j, 0, visit);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(total[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static void dfs(int start, int current, int finish, int sum, boolean[] visit) {
        if(current == finish) {
            total[start][finish] = Math.min(total[start][finish], sum);
            return;
        }

        for (int i = 0; i < Graph.length; i++) {
            if(Graph[current][i] != 0 && !visit[i]) {
                visit[i] = true;
                dfs(start, i, finish, sum + Graph[current][i], visit);
                visit[i] = false;
                if(i == finish) return;
            }
        }
    }
}