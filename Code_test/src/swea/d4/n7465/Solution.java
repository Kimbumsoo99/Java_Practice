package swea.d4.n7465;
import java.util.*;

class Solution {
    static int[][] Graph;
    static boolean[] visit;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Graph = new int[N][N];
            visit = new boolean[N];
            for (int i = 0; i < M; i++) {
                int A = sc.nextInt() - 1;
                int B = sc.nextInt() - 1;
                Graph[A][B] = Graph[B][A] = 1;
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (dfs(i)) {
                    count++;
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }

    static boolean dfs(int idx) {
        if (visit[idx]) {
            return false;
        }

        visit[idx] = true;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(idx);

        while (!dq.isEmpty()) {
            int tmp = dq.pollFirst();
            //System.out.println(tmp);
            for (int i = 0; i < Graph.length; i++) {
                if (i == tmp || visit[i]) {
                    continue;
                }
                if (Graph[tmp][i] == 1) {
                    dq.offer(i);
                    visit[i] = true;
                }
            }
        }
        return true;
    }
}
