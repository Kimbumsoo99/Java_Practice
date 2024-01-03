package swea.d2.n12712;

import java.util.Scanner;

public class Solution {
    static int[][] Graph;
    static int max;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy2 = new int[]{1, -1, -1, 1};
    static int[] dx2 = new int[]{1, 1, -1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Graph = new int[N][N];
            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                    System.out.println("******** " + i + " " + j);
                    findRook(i, j, M);
                    findBishop(i, j, M);
//                    System.out.println(max);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void findRook(int y, int x, int m) {
        int sum = Graph[y][x];
        for (int i = 0; i < 4; i++) {
            int nextY = y;
            int nextX = x;
            int tmpSum = 0;
            for (int j = 1; j < m; j++) {
                nextY += dy[i];
                nextX += dx[i];
                if (nextY >= 0 && nextX >= 0 && nextX < Graph.length && nextY < Graph.length) {
                    tmpSum += Graph[nextY][nextX];
                } else {
                    break;
                }
            }
            sum += tmpSum;
        }
        max = Math.max(max, sum);
    }
    private static void findBishop(int y, int x, int m) {
        int sum = Graph[y][x];
        for (int i = 0; i < 4; i++) {
            int nextY = y;
            int nextX = x;
            int tmpSum = 0;
            for (int j = 1; j < m; j++) {
                nextY += dy2[i];
                nextX += dx2[i];
                if (nextY >= 0 && nextX >= 0 && nextX < Graph.length && nextY < Graph.length) {
                    tmpSum += Graph[nextY][nextX];
                } else {
                    break;
                }
            }
            sum += tmpSum;
        }
        max = Math.max(max, sum);
    }
}
