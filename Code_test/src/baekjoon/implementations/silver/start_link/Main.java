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
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        visit = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new ArrayList<Integer>(), 0);
        System.out.println(min);
    }

    static void dfs(ArrayList<Integer> st, int depth){
        if (depth == Graph.length) {
            min = Math.min(min, minus(st));
            return;
        }

        for (int i = 0; i < Graph.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                st.add(i);
                dfs(st, depth + 1);
                st.remove(st.size() - 1);
                visit[i] = false;
            }
        }
    }

    static int minus(ArrayList<Integer> st){
        if (st.size() > Graph.length) {
            System.out.println("dddddddddddd");
        }
        // start 팀의 합산
        int start = 0;
        for (int i = 0; i < Graph.length / 2; i++) {
            for (int j = i; j < Graph.length / 2; j++) {
                if (i == j) {
                    continue;
                }
                int st1 = st.get(i);
                int st2 = st.get(j);
                start += (Graph[st1][st2] + Graph[st2][st1]);
            }
        }

        // link 팀의 합산
        int link = 0;
        for (int i = Graph.length / 2; i < Graph.length; i++) {
            for (int j = i; j < Graph.length; j++) {
                if (i == j) {
                    continue;
                }
                int li1 = st.get(i);
                int li2 = st.get(j);
                link += (Graph[li1][li2] + Graph[li2][li1]);
            }
        }
        int diff = Math.abs(start - link);
        return diff;
    }

}
