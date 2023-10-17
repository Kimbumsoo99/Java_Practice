package swea.d3.n2805;

import java.util.*;
// 2805. 농작물 수확하기
class Solution {

    static int[][] Graph;
    static boolean[][] visit;
    static int N;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            Graph = new int[N][N];
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String tmp = sc.next();
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = tmp.charAt(j) - '0';
                }
            }
            int answer = bfs();
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static int bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{N / 2, N / 2, 0});
        visit[N / 2][N / 2] = true;
        int answer = Graph[N / 2][N / 2];
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (tmp[2] < N / 2) {
                    if (!visit[nextY][nextX]) {
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                        answer += Graph[nextY][nextX];
                    }
                }
            }
        }
        return answer;
    }
}
