package baekjoon.algorithm.lis.s11053;
// 최장 증가 부분 수열 LIS 알고리즘

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
static int[] dp;
static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        seq = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        for (int i = 1; i < N + 1; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (seq[i] > seq[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > answer) {
                        answer = dp[i];
                    }
                }
            }
        }
//        for (int i = 1; i < N + 1; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();

        System.out.println(answer);
    }

}
