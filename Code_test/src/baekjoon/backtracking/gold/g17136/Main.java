package baekjoon.backtracking.gold.g17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int originMap[][], answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        originMap = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            if (flag)
                break;
            for (int j = 0; j < 10; j++) {
                if (originMap[i][j] == 1) {
                    flag = true;
                    for (int k = 0; k < 5; k++) {
                        dfs(i, j, originMap, k, new int[5], 1);
                    }
                    break;
                }
            }
        }
        if (!flag) {
            answer = Math.min(answer, 0);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void draw(int[][] map) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int y, int x, int[][] map, int idx, int[] count, int depth) {
        if (count[idx] + 1 > 5 || answer <= depth)
            return;
        // idx만큼 확인해서 가능하다면, 색종이를 붙인 map 정보에다가 다음 dfs를 넘겨주기
//		tmpMap[y][x] = 0;
//		if (idx > 0) {
//			for (int i = 1; i <= idx; i++) {
//				for (int j = 0; j <= i; j++) {
//					tmpMap[y + j][x + i] = 0;
//				}
//				for (int j = 0; j < i; j++) {
//					tmpMap[y + i][x + j] = 0;
//				}
//			}
//		}

        for (int i = y; i <= y + idx; i++) {
            for (int j = x; j <= x + idx; j++) {
                if (!isMap(i, j) || map[i][j] != 1) {
                    return;
                }
            }
        }

        for (int i = y; i <= y + idx; i++) {
            for (int j = x; j <= x + idx; j++) {
                map[i][j] = 0;
            }
        }

        count[idx]++;
        boolean flag = false;
        for (int i = y; i < 10; i++) {
            if (flag)
                break;
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    flag = true;
                    for (int k = 0; k < 5; k++) {
                        dfs(i, j, map, k, count, depth + 1);
                    }
                    break;
                }
            }
        }

        for (int i = y; i <= y + idx; i++) {
            for (int j = x; j <= x + idx; j++) {
                map[i][j] = 1;
            }
        }

        if (!flag) {
            answer = Math.min(answer, depth);
        }
        count[idx]--;
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < 10 && x < 10;
    }
}
