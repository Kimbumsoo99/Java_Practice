package baekjoon.dp.s11060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N + 1]; // 점프 횟수 적기
        Arrays.fill(dp, INF);

        dp[1] = 0;
        for (int i = 1; i < N + 1; i++) {
            int jump = arr[i];
            for (int j = 1; j <= jump; j++) {
                if (i + j > N)
                    break;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        System.out.println(dp[N] == INF ? -1 : dp[N]);

    }
}
