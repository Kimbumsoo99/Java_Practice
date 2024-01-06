package swea.d3.n5215;

import java.util.*;
class Solution {

    static ArrayList<int[]> list;
    static boolean[] visit;
    static int max;

    public static void main(String args[]) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt();
                int L = sc.nextInt();
                max = 0;
                list = new ArrayList<>();
                visit = new boolean[N];
                for (int i = 0; i < N; i++) {
                    int score = sc.nextInt();
                    int cal = sc.nextInt();
                    list.add(new int[]{score, cal});
                }
                for (int i = 0; i < N; i++) {
                    visit[i] = true;
                    dfs(N, i, list.get(i)[1], L, list.get(i)[0]);
                    visit[i] = false;
                }
                System.out.println("#" + test_case + " " + max);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void dfs(int N, int x, int cal, int L, int sum) {
        if (sum > max) {
            max = sum;
        }

        for (int i = x + 1; i < N; i++) {
            if (!visit[i] && cal + list.get(i)[1] <= L) {
                visit[i] = true;
                dfs(N, i, cal + list.get(i)[1], L, sum + list.get(i)[0]);
                visit[i] = false;
            }
        }
    }
}