package baekjoon.dfs.hiding_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] Graph;
    static boolean[] visit;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {-1, 1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int size = 200000;
        Graph = new int[size];
        visit = new boolean[size];

        int answer = bfs(N, M);
        System.out.println(answer);
    }

    static int bfs(int start, int finish){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start, 0});
        visit[start] = true;

        while (!q.isEmpty()){
            int[] tmp = q.poll();
            if (tmp[0] == finish) {
                return tmp[1];
            }

            for (int i = 0; i < 3; i++) {
                int nextX = i < 2 ? tmp[0] + dx[i] : tmp[0] * 2;
//                System.out.println(tmp[0] + " " + tmp[1] + " " + Graph.length);
                if (nextX >= 0 && nextX < Graph.length) {
                    if (!visit[nextX]) {
                        q.offer(new int[]{nextX, tmp[1] + 1});
                        visit[nextX] = true;
                    }
                }
            }
        }
        return -1;
    }

}
