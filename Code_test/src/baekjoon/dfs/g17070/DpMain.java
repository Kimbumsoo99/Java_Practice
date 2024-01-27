package baekjoon.dfs.g17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DpMain {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] ints = new int[N][N];
        long[][][] dp = new long[N][N][3]; // 가로, 세로, 대각

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    ints[i][j] = 0;
                } else {
                    ints[i][j] = -1;
                }
            }
        }
        // 끝점이 0,1은 항상 초기에 "->" 1개
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (ints[i][j] == -1) {
                    continue;
                }

                // 다음에 오른쪽으로 갈 수 있는 경우의 수
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                // 아래로 내려갈 수 있는 경우의 수
                if (i - 1 >= 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                // 대각선 아래로 내려갈 수 있는 경우의 수
                if (i - 1 >= 0 && ints[i - 1][j] == 0 && ints[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        bw.write(Arrays.stream(dp[N - 1][N - 1]).sum() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
