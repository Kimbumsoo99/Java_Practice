package baekjoon.dp.rgb_road;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static int[][] RGB;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        RGB = new int[N][3];
        dp = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][R] = RGB[0][R];
        dp[0][G] = RGB[0][G];
        dp[0][B] = RGB[0][B];

        System.out.println(Math.min(Math.min(cost(N - 1, R), cost(N - 1, G)), cost(N - 1, B)));
    }


    static int cost(int current, int color) {
        if (dp[current][color] == 0) {
            if (color == R) {
                dp[current][color] = Math.min(cost(current - 1, B), cost(current - 1, G)) + RGB[current][color];
            } else if (color == G) {
                dp[current][color] = Math.min(cost(current - 1, R), cost(current - 1, B)) + RGB[current][color];

            }else {
                dp[current][color] = Math.min(cost(current - 1, R), cost(current - 1, G)) + RGB[current][color];
            }
        }

        return dp[current][color];
    }
}
