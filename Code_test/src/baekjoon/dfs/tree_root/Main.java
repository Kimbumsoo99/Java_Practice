package baekjoon.dfs.tree_root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i <= N; i++) {
            Graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Graph.get(A-1).add(B-1);
            Graph.get(B-1).add(A-1);
        }

//        visit = new boolean[N];
        dfs();

        for (int i = 1; i < N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visit = new boolean[N];
        parent = new int[N];
        visit[0] = true;
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
//            System.out.println(tmp + 1);
            for (int next: Graph.get(tmp)) {
                if(!visit[next]){
//                    System.out.println(next + 1 + " " + Graph.get(tmp));
                    parent[next] = tmp + 1;
                    visit[next] = true;
                    stack.push(next);
                }
            }
//            for (int i = 0; i < N; i++) {
//                if (!visit[i] && Graph.get(tmp).get(i) == i) {
//                    if(i == correct) return tmp + 1;
//                    stack.push(i);
//                    visit[i] = true;
//                }
//            }
        }
    }
}
