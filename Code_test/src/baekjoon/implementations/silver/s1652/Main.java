package baekjoon.implementations.silver.s1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 누울 자리를 찾아라, 실버 V, 1652번
public class Main {
    static char[][] Graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                Graph[i][j] = tmp.charAt(j);
            }
        }
        int answerX = 0;
        int answerY = 0;
        // 가로 계산
        for (int i = 0; i < N; i++) {
            int countX = 0;
            for (int j = 0; j < N; j++) {
                if (Graph[i][j] != 'X') {
                    countX++;
                }else{
                    countX = 0;
                }

                if (countX == 2) {
                    answerX++;
                }
            }
        }

        // 세로 계산
        for (int i = 0; i < N; i++) {
            int countY = 0;
            for (int j = 0; j < N; j++) {
                if (Graph[j][i] != 'X') {
                    countY++;
                }else{
                    countY = 0;
                }

                if (countY == 2) {
                    answerY++;
                }
            }
        }
        System.out.println(answerX + " " + answerY);
    }
}
