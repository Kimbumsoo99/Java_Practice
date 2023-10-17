package baekjoon.dp.card_buy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                    * 실수한 풀이 -> 굳이 안해도 될 연산 한 번을 더했음
                    * dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i][j - i] + card[i]));
                    * */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i] + card[i]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[N][N]);
    }

}
