package baekjoon.dp.g2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K, dp[][], arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        dp[1][arr[1]] = 1;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (j - arr[i] > 0) {
                    dp[i][j] = Math.min(dp[i][j - arr[i]], dp[i - 1][j]) + 1;
                }
            }
        }
    }

}
