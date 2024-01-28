package baekjoon.data_structure.tree.g1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node> list[];
    static int N;
    static int max = 0;
    static boolean[] visit;
    static int max_idx = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        StringTokenizer st;
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B, L));
            list[B].add(new Node(A, L));
        }
        visit = new boolean[N + 1];
        visit[1] = true;
        dfs(1, 0);
        // root로 부터의 최대 거리를 작성
//        System.out.println();
        visit = new boolean[N + 1];
        visit[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);
    }
    static void dfs(int idx, int cnt){
        if (max < cnt) {
            max = cnt;
            max_idx = idx;
        }

        for (Node node : list[idx]) {
            if (!visit[node.idx]) {
                visit[node.idx] = true;
//                System.out.println(node.idx + " " + (cnt + node.cnt));
                dfs(node.idx, cnt + node.cnt);
            }
        }
    }

    static class Node {
        int idx;
        int cnt;
        Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
