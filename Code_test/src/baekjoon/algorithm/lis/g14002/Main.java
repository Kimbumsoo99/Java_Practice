package baekjoon.algorithm.lis.g14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] index = new int[N];

        dp[0] = 1;
        index[0] = -1;

        int max = 1;
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            index[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
            if(max < dp[i]){
                max = dp[i];
                maxIdx = i;
            }
        }
        System.out.println(max);
        StringBuilder sb = new StringBuilder();
        dfs(maxIdx, sb, index, arr);
        System.out.println(sb);
    }

    static void dfs(int idx, StringBuilder sb, int[] index, int[] arr){
        if (index[idx] == -1) {
            sb.append(arr[idx] + " ");
            return;
        }
        dfs(index[idx], sb, index, arr);
        sb.append(arr[idx] + " ");
    }
}
