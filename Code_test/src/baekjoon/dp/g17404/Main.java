package baekjoon.dp.g17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1번으로 시작 -> 2번이나 3번으로 끝나는 최소 경우
 * 2번으로 시작 -> 1번이나 3번으로 끝나는 최소 경우
 * 3번으로 시작 -> 1번이나 2번으로 끝나는 최소 경우
 */
public class Main {
    static int[][] arr, dp;
    static int smallIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][3];
        dp = new int[N + 1][3];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i + 1][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                dp[1][i] = k == i ? arr[1][k] : 987654321;
            }
            for (int i = 2; i < N + 1; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
            for (int i = 0; i < 3; i++) {
                if (i != k)
                    answer = Math.min(answer, dp[N][i]);
            }
        }
        System.out.println(answer);
    }
}

