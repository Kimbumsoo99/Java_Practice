package baekjoon.dp.s11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            A[i + 1] = tmp;
        }

        int answer = 0;
        for (int i = N; i > 0; i--) {
            dp[i] = A[i];
            int max = dp[i];
            for (int j = i + 1; j < N + 1; j++) {
                if (A[i] < A[j]) {
                    max = Math.max(max, dp[i] + dp[j]);
                }
            }
            dp[i] = max;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
