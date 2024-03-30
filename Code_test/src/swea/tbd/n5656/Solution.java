package swea.tbd.n5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
    static int N, R, C, originMap[][], answer;
    static int[] dx = { 1, 0, 0, -1 }, dy = { 0, -1, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            originMap = new int[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    originMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < C; i++) {
                solution(0, i, copy(originMap));
            }
            System.out.println("#" + test_case + " " + (answer == Integer.MAX_VALUE ? 0 : answer));
        }
    }

    static void draw(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void solution(int depth, int idx, int[][] map) {
        int[][] tmpMap = new int[R][C];
        tmpMap = copy(map);
        tmpMap = blockThrow(tmpMap, idx);
        if (tmpMap == null) {
            return;
        }
        if (depth == N - 1) {
//			System.out.println(depth + " " + idx);
//			draw(tmpMap);
            answer = Math.min(answer, countMap(tmpMap));
            return;
        }
//		System.out.println("오리진");
//		draw(tmpMap);
//		System.out.println("오리진");
        for (int i = 0; i < C; i++) {
            solution(depth + 1, i, copy(tmpMap));
        }
    }

    static int[][] blockThrow(int[][] map, int idx) {
        int nextY = 0;
        int nextX = idx;
        while (nextY < R) {
            if (map[nextY][nextX] == 0) {
                nextY += 1;
            } else {
                return blockRemove(nextY, nextX, map);
            }
        }
        return null;
    }

    static int[][] blockRemove(int y, int x, int[][] map) {
        boolean[][] visit = new boolean[R][C];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { y, x, map[y][x] });
        visit[y][x] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < cur[2]; j++) {
                    int nextY = cur[0] + dy[i] * j;
                    int nextX = cur[1] + dx[i] * j;
                    if (isMap(nextY, nextX) && !visit[nextY][nextX] && map[nextY][nextX] != 0) {
                        dq.offer(new int[] { nextY, nextX, map[nextY][nextX] });
                        map[nextY][nextX] = 0;
                        visit[nextY][nextX] = true;
                    }
                }
            }
            map[cur[0]][cur[1]] = 0;
        }
        map = blockDown(map);
        return map;
    }

    static int[][] blockDown(int[][] map) {
        int[][] tmp = new int[R][C];
        for (int i = 0; i < C; i++) {
            int idx = R - 1;
            for (int j = R - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    tmp[idx--][i] = map[j][i];
                }
            }
        }
        return tmp;
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < R && x < C;
    }

    static int countMap(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int[][] copy(int[][] origin) {
        int[][] copyMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copyMap[i][j] = origin[i][j];
            }
        }
        return copyMap;
    }
}
