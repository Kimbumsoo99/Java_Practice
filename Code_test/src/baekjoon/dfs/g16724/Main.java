package baekjoon.dfs.g16724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] Graph;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1}; // U R D L
    static int[] p;
    static boolean[][] visit, finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N * M];
        Graph = new int[N][M];
        visit = new boolean[N][M];
        finish = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = isDir(tmp[j]);
            }
        }

        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visit[i][j]) {
                    dfs(i, j, i * M + j);
                }
            }
        }
        System.out.println(answer);
    }

    public static void draw() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void dfs(int y, int x, int pre) {
        visit[y][x] = true;
        int ny = y + dy[Graph[y][x]];
        int nx = x + dx[Graph[y][x]];
        if (!visit[ny][nx]) {
            dfs(ny, nx, ny * M + nx);
        } else {
            if (!finish[ny][nx]) {
                answer++;
            }
        }
        finish[y][x] = true;
    }

    public static int isDir(char w){
        switch(w){
            case 'U':
                return 0;
            case 'D':
                return 2;
            case 'L':
                return 3;
            case 'R':
                return 1;
            default:
                return -1;
        }
    }
}