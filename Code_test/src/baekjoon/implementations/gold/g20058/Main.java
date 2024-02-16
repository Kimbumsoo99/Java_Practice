package baekjoon.implementations.gold.g20058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Graph[][];
    static int[] dx = new int[] { 0, 1, 0, -1 }, dy = new int[] { 1, 0, -1, 0 };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        R = (int) Math.pow(2, N);
        Graph = new int[R][R];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < R; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            fireStorm(Integer.parseInt(st.nextToken()));
//            System.out.println("위에서 감소한 모습---");
//            draw();
//            System.out.println(setCount());
//            System.out.println("=======================");
        }
        int count = setCount();
        int answer = 0;
        visit = new boolean[R][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                if (!visit[i][j] && Graph[i][j] != 0) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(count + "\n" + answer);
    }

    static int bfs(int y, int x) {
        int count = 1;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { y, x });
        visit[y][x] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX) && Graph[nextY][nextX] != 0 && !visit[nextY][nextX]) {
                    count++;
                    visit[nextY][nextX] = true;
                    dq.offer(new int[] { nextY, nextX });
                }
            }
        }
//        System.out.println("count : " + count);
        return count;
    }

    static int setCount() {
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                count += Graph[i][j];
            }
        }
        return count;
    }

    static void draw() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void fireStorm(int L) {
        int bin = (int) Math.pow(2, L);
        for (int i = 0; i < R; i += bin) {
            for (int j = 0; j < R; j += bin) {
                // 위치 마다 bin/2 만큼 위치 이동
                turn(i, j, bin);
            }
        }
//        System.out.println(L);
//        draw();
        // 모든 위치에 대하여 상하좌우 탐색 후 얼음 감소
        ArrayList<int[]> melts = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                if (iceMelt(i, j)) {
                    melts.add(new int[] { i, j });
                }
            }
        }
        for (int[] idx : melts) {
            Graph[idx[0]][idx[1]]--;
        }
    }

    static void turn(int y, int x, int bin) {
        if (bin == 1)
            return;
        int[][] turnMap = new int[bin][bin];
        for (int i = 0; i < bin; i++) {
            for (int j = 0; j < bin; j++) {
                turnMap[i][j] = Graph[y + bin - 1 - j][x + i];
            }
        }
        for (int i = 0; i < bin; i++) {
            for (int j = 0; j < bin; j++) {
                Graph[y + i][x + j] = turnMap[i][j];
            }
        }
//		int halfBin = bin / 2;
//		int[][] turnMap = new int[halfBin][halfBin];
//		for (int i = y; i < y + halfBin; i++) {
//			for (int j = x; j < x + halfBin; j++) {
//				turnMap[i - y][j - x] = Graph[i][j];
//			}
//		}
//
//		// 1사 분면 <- 3사 분면
//		for (int i = y; i < y + halfBin; i++) {
//			for (int j = x; j < x + halfBin; j++) {
//				Graph[i][j] = Graph[i + halfBin][j];
//			}
//		}
//
//		// 3사 분면 <- 4사 분면
//		for (int i = y; i < y + halfBin; i++) {
//			for (int j = x; j < x + halfBin; j++) {
//				Graph[i + halfBin][j] = Graph[i + halfBin][j + halfBin];
//			}
//		}
//
//		// 4사 분면 <- 2사 분면
//		for (int i = y; i < y + halfBin; i++) {
//			for (int j = x; j < x + halfBin; j++) {
//				Graph[i + halfBin][j + halfBin] = Graph[i][j + halfBin];
//			}
//		}
//
//		// 2사 분면 <- 저장된 1사 분면
//		for (int i = y; i < y + halfBin; i++) {
//			for (int j = x; j < x + halfBin; j++) {
//				Graph[i][j + halfBin] = turnMap[i - y][j - x];
//			}
//		}
    }

    static boolean iceMelt(int y, int x) {
        if (Graph[y][x] == 0)
            return false;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (isMap(nextY, nextX) && Graph[nextY][nextX] != 0) {
                count++;
            }
        }
        if (count < 3)
            return true;
        return false;
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < R && x < R) {
            return true;
        }
        return false;
    }
}