package baekjoon.dfs.tomato_three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] Graph;
    static boolean[][][] visit;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        Graph = new int[Z][Y][X];
        visit = new boolean[Z][Y][X];
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < X; k++) {
                    Graph[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        ArrayList<int[]> index = new ArrayList<>();

        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if (Graph[i][j][k] == 1) {
                        index.add(new int[]{i, j, k});
                    }
                }
            }
        }


        int answer = bfs(index);
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if (Graph[i][j][k] == 0 && !visit[i][j][k]) {
                        answer = -1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
    static int bfs(ArrayList index){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        Iterator<int[]> it = index.iterator();
        while (it.hasNext()) {
            int[] tmp =  it.next();
//            System.out.println(tmp[0] + " " + tmp[1] + " " + tmp[2]);
            q.offer(new int[]{tmp[0], tmp[1], tmp[2], 0});
            visit[tmp[0]][tmp[1]][tmp[2]] = true;
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 6; i++) {
                int nextX = tmp[2] + dx[i];
                int nextY = tmp[1] + dy[i];
                int nextZ = tmp[0] + dz[i];

                if(q.isEmpty()) count = tmp[3];
                if (nextY >= 0 && nextX >= 0 && nextZ >= 0 && nextZ < Graph.length
                    && nextY < Graph[0].length && nextX < Graph[0][0].length) {
                    if(!visit[nextZ][nextY][nextX] && Graph[nextZ][nextY][nextX] == 0){
                        q.offer(new int[]{nextZ, nextY, nextX, tmp[3] + 1});
                        visit[nextZ][nextY][nextX] = true;
                    }
                }
            }
        }
        return count;
    }


}
