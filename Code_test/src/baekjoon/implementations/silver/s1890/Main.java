package baekjoon.implementations.silver.s1890;



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.StringTokenizer;



// 1890 번

public class Main {

    static long[][] Graph;

    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Graph = new long[N][N];

        dp = new long[N][N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {

                Graph[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        dp[0][0] = 1;



        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (i == N - 1 && j == N - 1) {

                    break;

                }



                for (int k = 0; k < 2; k++) {

                    int nextY = i;

                    int nextX = j;

                    if (k == 0) {

                        nextY += Graph[i][j];

                    } else {

                        nextX += Graph[i][j];

                    }

                    if (nextY < N && nextX < N) {

                        dp[nextY][nextX] += dp[i][j];

                    }

                }



            }

        }

        System.out.println(dp[N - 1][N - 1]);

    }

}
