package baekjoon.dp.rock2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[1001];
        dp[1] = 1; // CY
        dp[2] = 2; // SK
        dp[3] = 1; // CY
        for (int i = 4; i < N + 1; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }
        if (dp[N] % 2 == 1) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

}
