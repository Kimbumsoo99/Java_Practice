package swea.d3.n2806;

import java.util.Scanner;

class Solution {

    static int[][] Graph;
    static int count;

    public static void main(String args[]) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();
            for (int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt();
                Graph = new int[N][N];
                count = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        Graph[i][j] = 1;
                        dfs(i, j, 1, N);
                        Graph[i][j] = 0;
                    }
                }
                System.out.println("#" + test_case + " " + count);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void dfs(int y, int x, int cnt, int N) {
        // 재귀 종료 조건
        if (cnt == N) {
            count++;
            return;
        }

        for (int i = y + 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isQueen(i, j)) {
                    Graph[i][j] = 1;
                    dfs(i, j, cnt + 1, N);
                    Graph[i][j] = 0;
                }
            }
        }
    }

    static boolean isQueen(int y, int x) {
        int N = Graph.length;
        for (int i = 0; i < Graph.length; i++) {
            if (Graph[y][i] == 1) {
                return false;
            }
            if (Graph[i][x] == 1) {
                return false;
            }
            if (x - i >= 0 && y - i >= 0) {
                if (Graph[y - i][x - i] == 1) {
                    return false;
                }
            }
            if (x - i >= 0 && y + i < N) {
                if (Graph[y + i][x - i] == 1) {
                    return false;
                }
            }
            if (x + i < N && y + i < N) {
                if (Graph[y + i][x + i] == 1) {
                    return false;
                }
            }
            if (x + i < N && y - i >= 0) {
                if (Graph[y - i][x + i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
