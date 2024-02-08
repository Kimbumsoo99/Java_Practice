package swea.d4.n1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
    static int[][] Graph;
    static int N, answerNum, answer;
    static int[] dx = new int[] { 0, 1, 0, -1 }, dy = new int[] { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            Graph = new int[N][N];
            answer = 0; // 방의 카운트
            answerNum = Integer.MAX_VALUE; // 방의 값
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(i, j);
                }
            }
            System.out.println("#" + test_case + " " + answerNum + " " + answer);
        }
    }

    static void bfs(int y, int x) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { y, x, 1 });
        boolean[][] visit = new boolean[N][N];
        visit[y][x] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (tmp[2] > answer) {
                answerNum = Graph[y][x];
                answer = tmp[2];
            } else if (tmp[2] == answer) {
                if (answerNum > Graph[y][x]) {
                    answerNum = Graph[y][x];
                }
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX) && !visit[nextY][nextX]) {
                    if (Graph[nextY][nextX] - Graph[tmp[0]][tmp[1]] == 1) {
                        visit[nextY][nextX] = true;
                        dq.offer(new int[] { nextY, nextX, tmp[2] + 1 });
                    }
                }
            }
        }
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < N) {
            return true;
        }
        return false;
    }
}
