package baekjoon.graph.bfs.g4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Graph[][], start[], answer = 0;
    static final int FIRE = 3, JIHUN = 2;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    static boolean[][] visit, fire;
    static ArrayDeque<int[]> fireDq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        visit = new boolean[N][M];
        fire = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if ('#' == arr[j]) {
                    Graph[i][j] = 1;
                } else if ('.' == arr[j]) {
                    Graph[i][j] = 0;
                } else if ('J' == arr[j]) {
                    Graph[i][j] = JIHUN; // 지훈
                    start = new int[] { i, j };
                    visit[i][j] = true;
                } else {
                    Graph[i][j] = FIRE; // 불
                    fireDq.offer(new int[] { i, j });
                    fire[i][j] = true;
                }
            }
        }

        if(bfs()) {
            System.out.println(answer);
        }else {
            System.out.println(failString());
        }


    }

    static boolean bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {start[0], start[1], 1});
        while (!dq.isEmpty()) {
            int f = fireDq.size();
            while (f-- > 0) {
                int[] bull = fireDq.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int nextY = bull[0] + dy[i];
                    int nextX = bull[1] + dx[i];
                    if (isMap(nextY, nextX) && Graph[nextY][nextX] != 1 && !fire[nextY][nextX]) {
                        fireDq.offer(new int[] { nextY, nextX });
                        fire[nextY][nextX] = true;

                    }
                }
            }
            int jSize = dq.size();
            while(jSize-- > 0) {
                int[] tmp = dq.pollFirst();
                for (int i = 0; i < 4; i++) {
                    int nextY = tmp[0] + dy[i];
                    int nextX = tmp[1] + dx[i];
                    if(!isMap(nextY, nextX)) {
                        answer = tmp[2];
                        return true;
                    }else if(Graph[nextY][nextX] != 1 && !fire[nextY][nextX] && !visit[nextY][nextX]) {
                        dq.offer(new int[] {nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                    }
                }

            }
        }
        return false;
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    static String failString() {
        return "IMPOSSIBLE";
    }
}
