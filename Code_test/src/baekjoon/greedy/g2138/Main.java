package baekjoon.greedy.g2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] arr;
    static boolean[] origin;
    static int answer = -1, count = 0, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[2][N];
        origin = new boolean[N];
        for (int i = 0; i < 2; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                if (i == 0 && tmp.charAt(j) - '0' == 1)
                    origin[j] = true;
                if (tmp.charAt(j) - '0' == 1) {
                    arr[i][j] = true;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            // 마지막 처리만 따로해주기.
            if (arr[0][i - 1] != arr[1][i - 1]) {
                turnLight(i);
                count++;
            }
            // 처음부터 맨 앞만 차근 차근 맞춰나가기
        }
        if (arr[0][N - 1] == arr[1][N - 1]) {
            answer = count;
        }

        arr[0] = origin;
        arr[0][0] = !arr[0][0];
        arr[0][1] = !arr[0][1];
        count = 1;
        for (int i = 1; i < N; i++) {
            // 마지막 처리만 따로해주기.
            if (arr[0][i - 1] != arr[1][i - 1]) {
                turnLight(i);
                count++;
            }
            // 처음부터 맨 앞만 차근 차근 맞춰나가기
        }
        if (arr[0][N - 1] == arr[1][N - 1]) {
            answer = answer == -1 ? count : Math.min(count, answer);
        }
        System.out.println(answer);
    }

    static void turnLight(int idx) {
        arr[0][idx - 1] = !arr[0][idx - 1];
        arr[0][idx] = !arr[0][idx];
        if (idx < N - 1) {
            arr[0][idx + 1] = !arr[0][idx + 1];
        }
    }
}
