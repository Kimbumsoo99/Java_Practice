package baekjoon.graph.bfs.g17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Graph[][], min = Integer.MAX_VALUE, zero = 0;
    static boolean[][] visit;
    static int[] arr;
    static int[] dy = new int[]{1, 0, -1, 0}, dx = new int[]{0, 1, 0, -1};
    static ArrayList<Virus> virusList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new int[N][N];
        visit = new boolean[N][N];

        arr = new int[M];

        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (Graph[i][j] == 0) {
                    zero++;
                }
                if (Graph[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        }

        comb(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void comb(int start, int idx) {
        if (idx == M) {
            bfs();
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            arr[idx] = i;
            comb(i + 1, idx + 1);
        }
    }

    private static void bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int zeroCnt = zero;
        visit = new boolean[N][N];
        for (int idx : arr) {
            dq.offer(new int[]{virusList.get(idx).y, virusList.get(idx).x, 0});
            visit[virusList.get(idx).y][virusList.get(idx).x] = true;
        }

        int time = 0;

        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            if(zeroCnt == 0) break;
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] != 1) {
                        visit[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        if (Graph[nextY][nextX] == 0) {
                            zeroCnt--;
                        }
                        time = tmp[2] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(time == Integer.MAX_VALUE) break;
            for (int j = 0; j < N; j++) {
                if (Graph[i][j] == 0 && !visit[i][j]) {
                    time = Integer.MAX_VALUE;
                    break;
                }
            }
        }

        min = Math.min(time, min);
    }

    private static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    static class Virus {
        int y;
        int x;

        public Virus(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}