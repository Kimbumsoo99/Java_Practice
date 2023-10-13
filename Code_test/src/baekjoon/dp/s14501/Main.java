package baekjoon.dp.s14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사, 실버 III, 14501번 문제
public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        int answer = 0;
        StringTokenizer st;

        int meeting[][] = new int[2][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            meeting[0][i] = T;
            meeting[1][i] = P;
        }

        for (int i = N; i > 0; i--) {
            int T = meeting[0][i - 1];
            int P = meeting[1][i - 1];
            dp[i] = 0;
            if (i + T <= N + 1) {
                dp[i] += P;
            }
//            System.out.println("day " + i + " " + dp[i]);
            int max = dp[i];
            for (int j = i + T; j < N + 1; j++) {
                max = Math.max(max, dp[i] + dp[j]);
            }
            dp[i] = max;
//            System.out.println("day " + i + " " + dp[i]);
            answer = Math.max(answer, max);
        }
//        for (int i = 1; i < N+1; i++) {
//            System.out.println(i + " " + dp[i]);
//        }
        System.out.println(answer);
    }
}
