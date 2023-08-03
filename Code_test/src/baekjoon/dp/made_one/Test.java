package baekjoon.dp.made_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기 문제
// dp를 몰라서 일단 재귀로 구현
public class Test {

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp(N, 0);
        System.out.println(answer);
    }

    static void dp(int N, int count) {
        System.out.println(N + " " + count);
        if (N == 1) {
            answer = Math.min(answer, count);
            return;
        }

        if (N % 3 == 0) {
            dp(N / 3, count + 1);
        }
        if (N % 2 == 0) {
            dp(N / 2, count + 1);
        }
        if (N > 1) {
            dp(N - 1, count + 1);
        }
    }

}
