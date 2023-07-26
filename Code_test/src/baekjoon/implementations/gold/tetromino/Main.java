package baekjoon.implementations.gold.tetromino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<int[][]> Tetromino = new ArrayList<>();
    static void init(){
        
    }
    static int answer = 0;
    
    static void tetro(int[] start){
        int y = start[1];
        int x = start[0];
        for (int i = 0; i < 15; i++) {
            int sum = Graph[y][x];
            if(i == 0){
                sum += Graph[y][x-1];  // 1 1 1 1
                sum += Graph[y][x+1];
                sum += Graph[y][x+2];
            } else if (i == 1) {       // 1
                sum += Graph[y-1][x];  // 1
                sum += Graph[y+1][x];  // 1
                sum += Graph[y+2][x];  // 1
            } else if (i == 2) {
                sum += Graph[y+1][x];  // 1 1
                sum += Graph[y][x+1];  // 1 1
                sum += Graph[y+1][x+1];
            } else if (i == 3) {
                sum += Graph[y-1][x];  // 1
                sum += Graph[y-2][x];  // 1
                sum += Graph[y][x+1];  // 1 1
            } else if (i == 4) {
                sum += Graph[y-1][x];  //   1
                sum += Graph[y-2][x];  //   1
                sum += Graph[y][x-1];  // 1 1
            } else if (i == 5) {
                sum += Graph[y][x-1];  // 1 1
                sum += Graph[y+1][x];  //   1
                sum += Graph[y+2][x];  //   1
            } else if (i == 6) {
                sum += Graph[y+1][x];  // 1 1
                sum += Graph[y+2][x];  // 1
                sum += Graph[y][x+1];  // 1
            } else if (i == 7) {
                sum += Graph[y-1][x-1];// 1
                sum += Graph[y][x-1];  // 1 1
                sum += Graph[y+1][x];  //   1
            } else if (i == 8) {
                sum += Graph[y-1][x+1];//   1
                sum += Graph[y][x+1];  // 1 1
                sum += Graph[y+1][x];  // 1
            } else if (i == 9) {
                sum += Graph[y][x+1];  //   1 1
                sum += Graph[y-1][x];  // 1 1
                sum += Graph[y-1][x-1];//
            } else if (i == 10) {
                sum += Graph[y][x-1];  //
                sum += Graph[y+1][x];  // 1 1
                sum += Graph[y+1][x+1];//   1 1
            } else if (i == 11) {
                sum += Graph[y][x-1];  //
                sum += Graph[y+1][x];  // 1 1 1
                sum += Graph[y][x+1];  //   1
            } else if (i == 12) {
                sum += Graph[y-1][x];  // 1
                sum += Graph[y][x+1];  // 1 1
                sum += Graph[y+1][x];  // 1
            } else if (i == 13) {
                sum += Graph[y-1][x];  //   1
                sum += Graph[y][x-1];  // 1 1
                sum += Graph[y+1][x];  //   1
            } else if (i == 14) {
                sum += Graph[y][x-1];  //   1
                sum += Graph[y+1][x];  // 1 1 1
                sum += Graph[y][x+1];  //
            }
        }
    }
    static int[][] Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Graph = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                tetro(new int[]{j, i});
            }
        }
    }
}
