package baekjoon.implementations.gold.tetromino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainDFS {
    static int[][] Graph;
    static boolean[][] visit;

    static int answer = 0;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    static void dfs(int[] start, int count, int sum){
        if(count == 3){
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = start[1] + dx[i];
            int nextY = start[0] + dy[i];
            if (nextY >= 0 && nextX >= 0 && nextX < Graph[0].length && nextY < Graph.length) {
                if (!visit[nextY][nextX]) {
                    visit[nextY][nextX] = true;
                    dfs(new int[]{nextY, nextX}, count + 1, sum + Graph[nextY][nextX]);
                    visit[nextY][nextX] = false;
                }
            }
        }
    }
    static void exception(int[] start, int sum){
//        System.out.println("현재 좌표 x:" + start[1] + " y:" + start[0]);
        for (int i = 0; i < 4; i++) {
            int tmp = sum;
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    int nextX = start[1] + dx[j];
                    int nextY = start[0] + dy[j];
                    if (nextY >= 0 && nextX >= 0 && nextX < Graph[0].length && nextY < Graph.length) {
//                        System.out.print(Graph[nextY][nextX] + " ");
                        tmp += Graph[nextY][nextX];
                    }else break;
                }
            }
//            System.out.println();
            answer = Math.max(answer, tmp);
        }
//        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Graph = new int[Y][X];
        visit = new boolean[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                visit[i][j] = true;
                dfs(new int[]{i, j}, 0, Graph[i][j]);
                visit[i][j] = false;

                // ㅗ, ㅏ, ㅓ, ㅜ
                exception(new int[]{i, j}, Graph[i][j]);
            }
        }
        System.out.println(answer);
    }
}
