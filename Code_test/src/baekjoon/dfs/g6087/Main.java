package baekjoon.dfs.g6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Graph[][], point[] = new int[2], min = Integer.MAX_VALUE;
    static int mir[][][];
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        mir = new int[4][N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 4; j++) {
                Arrays.fill(mir[j][i], 987654321);
            }
            for (int j = 0; j < M; j++) {
                char c = tmp.charAt(j);
                if (c == '*') {
                    Graph[i][j] = 1;
                } else if (c == 'C') {
//                    System.out.println("START : " + i + " " + j);
                    Graph[i][j] = 2;
                    point = new int[]{i, j};
                }
            }
        }
        bfs(point[0], point[1]);
        System.out.println(min);
    }

    static void bfs(int y, int x) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x, -1, -1}); // y, x, dir, 방향 전환 count
        visit[y][x] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
//                System.out.println(nextY + " : " + nextX);
                if (isMap(nextY, nextX) && Graph[nextY][nextX] != 1) {
                    if ((y != nextY || x != nextX) && Graph[nextY][nextX] == 2) {
                        int mirror = tmp[3];
                        if (tmp[2] != i) {
                            mirror += 1;
                        }
                        min = Math.min(min, mirror);
                    }
                    if (!visit[nextY][nextX] || mir[i][nextY][nextX] > tmp[3] + (tmp[2] == i ? 0 : 1)) {
                        visit[nextY][nextX] = true;
                        mir[i][nextY][nextX] = tmp[3] + (tmp[2] == i ? 0 : 1);
//                        System.out.println(
//                            Arrays.toString(tmp) + " " + nextY + " " + nextX + " " + i + " "
//                                + mir[i][nextY][nextX]);
                        if (tmp[2] != i) { // 방향 전환 된 케이스
                            dq.offer(new int[]{nextY, nextX, i, tmp[3] + 1});
                        } else {
                            dq.offer(new int[]{nextY, nextX, i, tmp[3]});
                        }
                    }
                }
            }
        }
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }
}
