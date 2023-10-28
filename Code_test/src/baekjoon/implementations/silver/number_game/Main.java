package baekjoon.implementations.silver.number_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] game;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        game = new int[N][5];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxScore = -1;
        int winner = -1;
        for (int i = 0; i < N; i++) {
            int player = i + 1;
            int score = getScore(game[i]);
//            System.out.println(score);
            if (maxScore <= score) {
                winner = player;
                maxScore = score;
            }
        }
        System.out.println(winner);
    }

    static int getScore(int[] score) {
        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int tmp = score[i] + score[j] + score[k];
                    tmp %= 10;
                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }
        }
        return max;
    }
}
