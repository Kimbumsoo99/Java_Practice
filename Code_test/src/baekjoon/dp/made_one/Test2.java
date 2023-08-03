package baekjoon.dp.made_one;

// 반대로 구현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    static int answer = Integer.MAX_VALUE;
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp(1, 0);
        System.out.println(answer);
    }

    static void dp(int num, int count) {
//        System.out.println(N + " " + count);
        if (num == N) {
            answer = Math.min(answer, count);
            return;
        }
        if (num * 3 <= N) {
            dp(num * 3, count + 1);
        }
        if (num * 2 <= N) {
            dp(num * 2, count + 1);
        }
        if (num + 1 <= N) {
            dp(num + 1, count + 1);
        }
    }
}
