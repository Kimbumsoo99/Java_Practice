package baekjoon.dp.rock_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돌 게임, 실버 V, 9655
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean dp[] = new boolean[N];
        // N == 1 또는 3 이면, 상근이가 승리한다.
        dp[0] = true;
        if (N > 1) {
            dp[1] = false;
        }
        if (N > 2) {
            dp[2] = true;
        }
        for (int i = 3; i < N; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3];
        }
        if (dp[N - 1]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

}
