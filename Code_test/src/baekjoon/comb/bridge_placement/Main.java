package baekjoon.comb.bridge_placement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];
    static int comb(int N, int K) {

        // 이미 풀었던 sub문제일 경우 값을 재활용
        if(dp[N][K] > 0) {
            return dp[N][K];
        }

        // 2번 성질
        if(N == K || K == 0) {
            return dp[N][K] = 1;
        }
        // 1번 성질
        return dp[N][K] = comb(N - 1, K - 1) + comb(N - 1, K);
    }
    static int factorial(int N){
        return N * factorial(N-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            result.append(comb(Y, X)).append("\n");
        }
        System.out.println(result);
    }
}
