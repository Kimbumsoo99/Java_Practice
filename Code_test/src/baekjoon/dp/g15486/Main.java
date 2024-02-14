package baekjoon.dp.g15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S[][], dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        S = new int[2][N + 1];
        dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken());
            S[0][i] = A;
            S[1][i] = B;
        }

        for (int i = N; i > 0; i--) {
            int can = i + S[0][i];
            if (can <= N) {
                dp[i] = Math.max(dp[i + 1], S[1][i] + dp[can + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
//			System.out.println(i + " " + Arrays.toString(dp));
        }
        System.out.println(dp[1]);
    }
}
