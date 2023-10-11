package baekjoon.dp.rock_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BottomUp {
    static boolean[] dp; // true -> SK 승
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1 || N == 3) {
            System.out.println("SK");
            return;
        } else if (N == 2) {
            System.out.println("CY");
            return;
        }
        dp = new boolean[N];
        dp[0] = true;
        dp[1] = false;
        dp[2] = true;
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
