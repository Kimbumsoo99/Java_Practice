package swea.d3.n11315;

import java.util.Scanner;

class Solution {
    static int[][] Graph;
    static int[] dx = new int[]{1, 1, 1, 0};
    static int[] dy = new int[]{-1, 0, 1, 1};
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            Graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                String tmp = sc.next();
                for (int j = 0; j < N; j++) {
                    if (tmp.charAt(j) == '.') {
                        Graph[i][j] = 0;
                    } else {
                        Graph[i][j] = 1;
                    }
                }
            }
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (omok(i, j)) {
                        System.out.println("#" + test_case + " YES");
                        flag = true;
                    }

                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                System.out.println("#" + test_case + " NO");
            }
        }
    }

    static boolean omok(int y, int x) {
        if (Graph[y][x] == 0) {
            return false;
        }
//        System.out.println("omok : " + y + " " + x + " " + Graph[y][x]);
        for (int i = 0; i < 4; i++) {
            int count = 1;
            if (isNotDone(y, x, i, Graph[y][x])) {
                // 대각 위, 오른쪽, 대각 아래, 아래 방향 반대 방향에 돌 존재 시
                // true 반환을 통해 스킵
                continue;
            }

            int nextY = y + dy[i];
            int nextX = x + dx[i];
            for (int j = 2; j <= 5; j++) {
                if (nextY >= 0 && nextX >= 0 && nextX < Graph.length && nextY < Graph.length) {
                    if (Graph[nextY][nextX] == Graph[y][x]) {
                        count++;
                        nextY += dy[i];
                        nextX += dx[i];
//                        System.out.println(count + " " + nextY + " " + nextX);
                        if (j > count) {
                            break;
                        }
                    }
                }
            }
            if (count == 5) {
                return true;
            }
        }
        return false;

    }

    private static boolean isNotDone(int y, int x, int i, int value) {
        int preY = y - dy[i];
        int preX = x - dx[i];
        if (preY < 0 || preX < 0 || preY >= Graph.length || preX >= Graph.length) {
            return false; // 그래프 밖이면 상관 X
        }
        if (Graph[preY][preX] == value) {
            return true;
        }
        return false;
    }
}
