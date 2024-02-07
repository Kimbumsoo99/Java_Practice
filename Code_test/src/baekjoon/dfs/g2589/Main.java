package baekjoon.dfs.g2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static char[][] Graph;
    static boolean[][] visit;
    static ArrayList<int[]> list = new ArrayList<>();
    static int N, M, answer = 0, dy[] = new int[]{0,1,0,-1}, dx[] = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = tmp.charAt(j);
                if (Graph[i][j] == 'L') {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int[] idx : list) {
            bfs(idx);
        }
        System.out.println(answer);
    }

    static void bfs(int[] idx){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{idx[0], idx[1], 0});
        visit = new boolean[N][M];
        visit[idx[0]][idx[1]] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            answer = Math.max(answer, tmp[2]);
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] == 'L') {
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }

}
