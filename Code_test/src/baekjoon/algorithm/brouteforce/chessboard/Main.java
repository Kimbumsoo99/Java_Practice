package baekjoon.brouteforce.chessboard;

import java.util.Scanner;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;
    public static void find(int x, int y){
        int count = 0;

        boolean TF = arr[x][y];	// 첫 번째 칸의 색

        for(int i = x; i<x+8;i++){
            for(int j = y; j<y+8; j++){
                if(arr[i][j] != TF){
                    count++;
                }
                TF = !TF;
            }
            TF = !TF;
        }
        count = Math.min(count, 64 - count); // 이 부분은 놓쳤네요.

        min = Math.min(count, min);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new boolean[N][M];

        for(int i = 0; i < N;i++){
            String buffer = sc.next();

            for(int j = 0; j < M;j++){
                if(buffer.charAt(j) == 'W') arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        for(int i = 0; i < N - 7;i++){
            for(int j =0;j<M-7;j++){
                find(i, j);
            }
        }
        System.out.println(min);
    }
}
