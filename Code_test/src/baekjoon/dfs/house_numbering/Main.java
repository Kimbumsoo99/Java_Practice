package baekjoon.dfs.house_numbering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visit;
    static int[][] Graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] house;
    static int N;
    static int count = 1;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static void bfs(int y, int x, int count){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visit[y][x] = true;
        house[y][x] = count;
        int length = 0;
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            length++;
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if(!visit[nextY][nextX] && Graph[nextY][nextX] == 1){
                        q.offer(new int[]{nextY, nextX});
                        house[nextY][nextX] = count;
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
        list.add(length);
//        sb.append(length).append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        visit = new boolean[N][N];
        house = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(str[j]);
//                System.out.print(Graph[i][j]);
            }
//            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && Graph[i][j] == 1){
                    bfs(i, j, count++);
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(house[i][j] + " ");
//            }
//            System.out.println();
//        }
        Collections.sort(list);
        for (int i = 0; i < count - 1; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(count-1);
        System.out.println(sb);
    }
}
