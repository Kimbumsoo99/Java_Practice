package baekjoon.dp.g2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 동전 1, 골드 V
public class Main {
    static int[][] dp;
    static int[] S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        S = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            S[i] = Integer.parseInt(br.readLine());
            dp[i][0] = 1;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                if(j >= S[i]) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-S[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
//
//		for (int i = 1; i < N+1; i++) {
//			for (int j = 1; j < K+1; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//
        System.out.println(dp[N][K]);

    }
}
