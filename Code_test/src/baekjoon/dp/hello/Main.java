package baekjoon.dp.hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안녕, 실버 II
public class Main {

    static int dp[][];
    static int happy[];
    static int health[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        happy = new int[N + 1];
        health = new int[N + 1];
        dp = new int[N + 1][101]; // 점수 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health[i + 1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            happy[i + 1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 100; j++) {
                if (j < health[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - health[i]] + happy[i]);
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}
