package baekjoon.dp.s2670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 연속부분 최대곱, 실버 4
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        int N = Integer.parseInt(st.nextToken());
        double dp[] = new double[N+1];
        double S[] = new double[N+1];
        for (int i = 1; i < N+1; i++) {
            S[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(S[i], dp[i-1] * S[i]);
            if(max < dp[i]) max = dp[i];
        }
        double answer = Math.round((max*1000)) / 1000.0;
        System.out.printf("%.3f", answer);
    }
}

