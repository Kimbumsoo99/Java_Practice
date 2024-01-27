package baekjoon.dfs.g17070;
// 파이프 옮기기, DP

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static  int[][] Graph;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 1); // 가로
        System.out.println(count);
    }

    static void dfs(int dir, int y, int x){
        if (y == N || x == N || Graph[y][x] == 1) {
            return;
        }else if (y == N - 1 && x == N - 1) {
//            System.out.println("!S");
            count++;
            return;
        } else if ((y == N - 1 && dir == 1) || (x == N - 1 && dir == 0)) {
            return;
        }

        if (dir == 0) {
            dfs(0, y, x + 1);
        } else if (dir == 1) {
            dfs(1, y + 1, x);
        }else{
            dfs(0, y, x + 1);
            dfs(1, y + 1, x);
        }
        if (y < N - 1 && x < N - 1 && Graph[y + 1][x] != 1 && Graph[y][x + 1] != 1
            && Graph[y + 1][x + 1] != 1) {
            dfs(2, y + 1, x + 1);
        }

    }
}
