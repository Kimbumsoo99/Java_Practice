package baekjoon.dfs.g13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ABCDE, 골드 5
// 두잇 예제
public class Main {
    static ArrayList<Integer>[] Graph;
    static boolean flag = false;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Graph[A].add(B);
            Graph[B].add(A);
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            dfs(i, 1, N);
        }
        if(flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int idx, int depth, int N) {
        if (flag || depth == 5) {
            flag = true;
            return;
        }
        for (Integer i : Graph[idx]) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, depth + 1, N);
                visit[i] = false;
            }
        }
    }

}
