package baekjoon.implementations.silver.omok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int[] dx = new int[]{1, 1, 1, 0};
    static int[] dy = new int[]{-1, 0, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 19;
        Graph = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer[] = new int[3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (omok(i, j)) {
                    answer[0] = Graph[i][j];
                    answer[1] = i + 1;
                    answer[2] = j + 1;
                    System.out.println(answer[0]);
                    System.out.println(answer[1] + " " + answer[2]);
                    return;
                }
            }
        }
        System.out.println(0);
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
            for (int j = 2; j <= 6; j++) {
                if (nextY >= 0 && nextX >= 0 && nextX < 19 && nextY < 19) {
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
        if (preY < 0 || preX < 0 || preY >= 19 || preX >= 19) {
            return false; // 그래프 밖이면 상관 X
        }
        if (Graph[preY][preX] == value) {
            return true;
        }

        return false;
    }
}
