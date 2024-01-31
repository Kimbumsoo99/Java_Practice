package baekjoon.algorithm.divide_and_conquer.g2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] star = new char[][] { { '*', '*', '*' }, { '*', ' ', '*' }, { '*', '*', '*' } };
    static char[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = new char[N][N];
        init(); // 지우기
        make(0, 0, N, N, N / 3); // 0, 0, 9, 9, 3
        draw();
    }

    private static void init() {
        for (int i = 0; i < answer.length; i++) {
            Arrays.fill(answer[i], ' ');
        }

    }

    private static void draw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                sb.append(answer[i][j]);
//				System.out.print(answer[i][j]);
            }
            sb.append("\n");
//			System.out.println();
        }
        System.out.println(sb);
    }

    private static void make(int startY, int startX, int y, int x, int n) {
//		System.out.println(startY + " " + startX + " " + y + " " + x + " " + n);
        if (n != 1) {
            for (int i = startY; i < startY + y; i += n) {
                for (int j = startX; j < startX + x; j += n) {
                    if (i == startY + n && j == startX + n)
                        continue;
                    make(i, j, y / 3, x / 3, n / 3);
                }
            }
        } else {
            for (int i = startY; i < startY + 3; i++) {
                for (int j = startX; j < startX + 3; j++) {
                    answer[i][j] = star[i - startY][j - startX];
                }
            }
        }

    }
}

