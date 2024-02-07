package baekjoon.algorithm.bit_masking.g1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Other {
    static int R, C;
    static int[][] board, vis;
    static boolean[] ck = new boolean[26];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = cArr[j] - 'A';
            }
        }

        vis = new int[R][C];
        vis[0][0] = 1 << (board[0][0]);
        ck[board[0][0]] = true;
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        System.out.println(x + ", " + y);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                int next = board[nx][ny]; // 다음 좌표 알파벳
                if (!ck[next]) { // 중복되는 알파벳을 탐색
                    int route = 1 << next; // 다음 좌표 알파벳 식별자
                    if (vis[nx][ny] != (vis[x][y] | route)) { // 다음 좌표가 현재 좌표 + 다음좌표 식별자랑 다르면 다른 경로
                        System.out.println(vis[nx][ny] + " " +vis[x][y] + " " + route);
                        vis[nx][ny] = vis[x][y] | route;
                        ck[next] = true;
                        int nextResult = bfs(nx, ny);
                        result = Math.max(result, nextResult);
                        ck[next] = false;
                    }
                }
            }
        }
        return result + 1;
    }
}
