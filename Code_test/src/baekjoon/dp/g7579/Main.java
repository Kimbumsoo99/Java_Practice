package baekjoon.dp.g7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] arr;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int K = 0;
        for (int i = 0; i < N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
            K += arr[i][1];
        }

        dp = new int[N + 1][K + 1];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            int v = arr[i - 1][0];
            int w = arr[i - 1][1];
            for (int j = 0; j < K + 1; j++) {
                if (j - w < 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j]);
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                if (dp[i][j] >= M) {
                    min = Math.min(min, j);
                }
            }
//			System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(min);
    }
}
