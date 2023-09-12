package baekjoon.dfs.s2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int findA = Integer.parseInt(st.nextToken()) - 1;
        int findB = Integer.parseInt(st.nextToken()) - 1;
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            Graph[A][B] = Graph[B][A] = 1;
        }
        int answer = bfs(findA, findB);
        System.out.println(answer);
    }

    static int bfs(int A, int B) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{A, 0});
        visit[A] = true;
        int find = -1;
        while (!dq.isEmpty() && find == -1) {
            int tmp[] = dq.pollFirst();
            for (int i = 0; i < Graph.length; i++) {
                if (i == tmp[0]) {
                    continue;
                }
                if (!visit[i] && Graph[tmp[0]][i] == 1) {
                    if (i == B) {
                        find = tmp[1] + 1;
                    }
                    dq.offer(new int[]{i, tmp[1] + 1});
                    visit[i] = true;
                }
            }
        }
        return find;
    }
}
