package baekjoon.dfs.s24480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, answer[], count = 1;
    static ArrayList<ArrayList<Integer>> lists;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];
        lists = new ArrayList<>();
        visit = new boolean[N + 1];
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lists.get(A).add(B);
            lists.get(B).add(A);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(lists.get(i), Collections.reverseOrder());
        }
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int i) {
        visit[i] = true;
        answer[i] = count++;
        for (int next : lists.get(i)) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}
