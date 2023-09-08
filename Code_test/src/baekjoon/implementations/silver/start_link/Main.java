package baekjoon.implementations.silver.start_link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[] visit;
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        visit = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int idx, int depth){
        if (depth == N / 2) {
            min = Math.min(min, minus());
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    static int minus(){
        // start 팀의 합산
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // 둘 다 true라면 start 팀
                if (visit[i] && visit[j]) {
                    start += Graph[i][j];
                    start += Graph[j][i];
                }// 둘 다 false라면 link 팀
                else if (!visit[i] && !visit[j]) {
                    link += Graph[i][j];
                    link += Graph[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }
        return diff;
    }

}
