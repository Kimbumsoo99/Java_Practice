package baekjoon.dfs.s24444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] Graph;
    static int count = 0, countArr[];
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        countArr = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            Graph[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Graph[A].add(B);
            Graph[B].add(A);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(Graph[i]);
        }
        bfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(countArr[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        visit[start] = true;
        while (!dq.isEmpty()) {
            int tmp = dq.pollFirst();
            countArr[tmp] = ++count;
            for (Integer next : Graph[tmp]) {
                if (!visit[next]) {
                    visit[next] = true;
                    dq.offer(next);
                }
            }
        }
    }
}
