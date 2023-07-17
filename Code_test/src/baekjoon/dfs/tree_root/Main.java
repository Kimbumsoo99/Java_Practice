package baekjoon.dfs.tree_root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[][] Graph;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Graph = new int[N][N];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Graph[A-1][B-1] = Graph[B-1][A-1] = 1;
        }

//        visit = new boolean[N];
        for (int i = 2; i < N + 1; i++) {
//            dfs_2(0,i - 1, 0);
            int num = dfs(i - 1);
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int correct){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visit = new boolean[N];
        visit[0] = true;
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
//            System.out.println(tmp);
            for (int i = 0; i < N; i++) {
                if (!visit[i] && Graph[tmp][i] == 1) {
                    if(i == correct) return tmp + 1;
                    stack.push(i);
                    visit[i] = true;
                }
            }
        }
        return -1;
    }

//    static void dfs_2(int current, int correct, int root){
//        visit[current] = true;
////        System.out.println(current + " " + root);
//        if (current == correct) {
//            sb.append(root + 1).append("\n");
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            if (!visit[i] && Graph[current][i] == 1) {
//                visit[i] = true;
//                dfs_2(i, correct, current);
//                visit[i] = false;
//            }
//        }
//    }
}
