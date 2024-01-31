package baekjoon.algorithm.divide_and_conquer.g2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] star = new char[][] { { ' ', ' ', '*', ' ', ' ' }, { ' ', '*', ' ', '*', ' ' },
        { '*', '*', '*', '*', '*' } };

    static char[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = new char[N][N * 2];
        int K = N / 3; // N==24 K == 8
        init();
        star(0, 0, N, N * 2, N); // N==6 6, 12 N==24 24, 48
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
            for (int j = 0; j < answer[0].length; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void star(int startY, int startX, int y, int x, int n) {
//		System.out.println(startY + " " + startX + " " + y + " " + x + " " + n);
        if (n == 3) {
            for (int i = startY; i < startY + star.length; i++) {
                for (int j = startX; j < startX + star[0].length; j++) {
//					System.out.println("answer : " + i + " " + j);
                    answer[i][j] = star[i - startY][j - startX];
                }
            }
            return;
        }

        star(startY, startX + n / 2, y, x, n / 2);
        star(startY + n / 2, startX, y, x, n / 2);
        star(startY + n / 2, startX + n, y, x, n / 2);

//		for (int i = startY; i < y; i += n / 2) {
//			for (int j = startX; j < x; j += n) {
//				star(i, j, y / 2, x / 2, n / 2);
//			}
//		}
    }
}
