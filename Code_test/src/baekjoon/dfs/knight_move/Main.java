package baekjoon.dfs.knight_move;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] finish = new int[]{Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())};
            solution(N, start, finish);
        }
        System.out.println(sb);
    }

    private static void solution(int n, int[] start, int[] finish) {
        int moved = bfs(n, start, finish);
        sb.append(moved).append("\n");
    }

    private static int bfs(int N, int[] start, int[] finish) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        dq.offer(new int[]{start[0], start[1], 0});
        visit[start[0]][start[1]] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (tmp[0] == finish[0] && tmp[1] == finish[1]) {
                return tmp[2];
            }
            for (int i = 0; i < 8; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N) {
                    if (!visit[nextY][nextX]) {
//                        System.out.println(nextY + " " + nextX + " " + tmp[2]);
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
        return -1;
    }

}
