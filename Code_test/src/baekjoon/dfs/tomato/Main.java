package baekjoon.dfs.tomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int day = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        Graph = new int[Y][X];
        visit = new boolean[Y][X];

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if(Graph[i][j] == 1){
                    list.add(new int[]{j, i});
                }
            }
        }
        bfs(list);
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if(!visit[i][j] && Graph[i][j] == 0) day = -1;
            }
        }
        System.out.println(day);
    }
    static void bfs(ArrayList list) {
        Queue<int[]> q = new LinkedList<>();

        Iterator<int[]> it = list.iterator();
//        System.out.println(list.size());
        while (it.hasNext()){
            int[] tmp = it.next();
//            System.out.println(tmp[0] +" "+ tmp[1]);
            q.offer(new int[]{tmp[1], tmp[0], 0});
            visit[tmp[1]][tmp[0]] = true;
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if(q.isEmpty()) day = tmp[2];

            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextX < Graph[0].length && nextY < Graph.length) {
                    if(!visit[nextY][nextX] && Graph[nextY][nextX] == 0){
                        q.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                    }
                }
            }

        }
    }
}
