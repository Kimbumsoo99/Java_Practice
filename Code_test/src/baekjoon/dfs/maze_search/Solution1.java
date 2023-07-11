package baekjoon.dfs.maze_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀구현 오답
/*
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
위 경우 갈 수 있는 경우가 2개라서 문제가 발생

윗 부분 해결 완료하였지만 DFS 문제점이 있었음.
input:

4 4
1111
0011
0010
0011

output: 9

answer: 7
 */
public class Solution1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 우 -> 하 -> 좌 -> 상
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] Graph;
    static boolean[][] visit;
    static int N;
    static int M;
    static int cnt = Integer.MAX_VALUE;
    static void dfs(int x, int y, int count){
        visit[y][x] = true;
//        System.out.println(Graph[y][x] + " " + x + " "+ y +" "+ count);
        if (x == M-1 && y == N-1) {
            cnt = Math.min(cnt, count);
            visit[y][x] = false;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[] list = {dx[i], dy[i]};
            if (x + dx[i] >= 0 && x + dx[i] < M && y + dy[i] >= 0 && y + dy[i] < N) {
                if (!visit[(y + list[1])][(x + list[0])] && Graph[(y + list[1])][(x + list[0])] == 1) {
//                    System.out.println((x + list[0]) + " " + (y + list[1]));
                    dfs(x + list[0], y + list[1], count+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        dfs(0, 0, 1);
        System.out.println(cnt);
    }
}
