package baekjoon.graph.bfs.g23747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = new int[]{1, 0, -1, 0}, dy = new int[]{0, -1, 0, 1}; // RULD
    static char[][] Graph, answer;
    static char[] cmd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new char[N][M];
        answer = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Graph[i] = arr;
                answer[i][j] = '#';
            }
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;

        cmd = br.readLine().toCharArray();

        solution(y, x);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    static int dir(char cmd) {
        // RULD
        switch (cmd) {
            case 'R':
                return 0;
            case 'U':
                return 1;
            case 'L':
                return 2;
            default:
                return 3;
        }
    }

    static void solution(int y, int x) {
        int cY = y;
        int cX = x;
        for (char c : cmd) {
            if (c == 'W') {
                bfs(cY, cX, Graph[cY][cX]);
            } else {
                int d = dir(c);
                cY += dy[d];
                cX += dx[d];
            }
        }
        answer[cY][cX] = '.';
        for (int i = 0; i < 4; i++) {
            int nY = cY + dy[i];
            int nX = cX + dx[i];
            if (isMap(nY, nX)) {
                answer[nY][nX] = '.';
            }
        }
    }

    static void bfs(int y, int x, char cur){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x});
        answer[y][x] = '.';
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nY = tmp[0] + dy[i];
                int nX = tmp[1] + dx[i];
                if (isMap(nY, nX) && answer[nY][nX] == '#' && Graph[nY][nX] == cur) {
                    dq.offer(new int[]{nY, nX});
                    answer[nY][nX] = '.';
                }
            }
        }
    }
}
