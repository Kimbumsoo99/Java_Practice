package baekjoon.implementations.silver.bingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean finish = false;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                count++;
                int tmp = Integer.parseInt(st.nextToken());
                finish = check(tmp);
                if(finish) break;
            }
            if(finish) break;
        }
        System.out.println(count);
    }


    static boolean check(int num){
        remove(num);
        int bingo = 0;

        // 대각선 확인
        int count = 0;
        for (int i = 0, j = 0; i < 5 && j < 5; i++, j++) {
            if(board[i][j] == -1){
                count++;
            }
            if(count == 5){
                bingo++;
            }
        }

        count = 0;
        for (int i = 4, j = 0; i >= 0 && j < 5; i--, j++) {
            if(board[i][j] == -1){
                count++;
            }
            if(count == 5){
                bingo++;
            }
        }

        // 가로, 세로 확인
        for (int i = 0; i < 5; i++) {
            int countX = 0;
            int countY = 0;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == -1) {
                    countX++;
                }
                if (board[j][i] == -1) {
                    countY++;
                }

                if(countX == 5){
                    bingo++;
                }
                if (countY == 5) {
                    bingo++;
                }
            }
        }
        if(bingo < 3){
            return false;
        }
        return true;
    }
    static void remove(int num){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (num == board[i][j]) {
                    board[i][j] = -1;
                    return;
                }
            }
        }
    }
}
