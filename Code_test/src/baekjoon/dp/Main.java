package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 5557
    static int[] arr;
    static long[] dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sum;
        arr = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum = Integer.parseInt(st.nextToken());

        dp = new long[21][N - 1];
        dp[arr[0]][0] = 1;
        for (int i = 1; i < N - 1; i++) {
            int cur = arr[i];
            for (int j = 0; j < 21; j++) {
                if (dp[j][i - 1] != 0) {
                    if (j - cur >= 0) {
                        dp[j - cur][i] += dp[j][i - 1];
                    }
                    if(j + cur <= 20){
                        dp[j + cur][i] += dp[j][i - 1];
                    }
                }
            }
        }
        System.out.println(dp[sum][N - 2]);
    }
}
