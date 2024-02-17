package baekjoon.data_structure.queue.g10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new boolean[N + 1][N + 1];
        arr = new int[N + 1];
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i][i] = true;
            if (i < N && arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }

        int L = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    static int isPal(int start, int end) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = start; i < end; i++) {
            dq.offer(arr[i]);
        }
        while (dq.size() > 1) {
            int A = dq.pollFirst();
            int B = dq.pollLast();
            if (A != B) {
                return 0;
            }
        }
        return 1;
    }
}
