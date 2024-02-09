package baekjoon.algorithm.lis.s11053;

import java.io.*;
import java.util.*;

public class Main2 {
    // 완탐 느낌으로 DP를 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1001];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1; // 현재 위치 + 1
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
