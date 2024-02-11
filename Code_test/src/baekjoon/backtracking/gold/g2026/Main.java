package baekjoon.backtracking.gold.g2026;
import java.io.*;
import java.util.*;

public class Main {
    static int K, N, F;
    static boolean[][] linked;
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    static int[] answer;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        answer = new int[K];
        linked = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lists.get(A).add(B);
            lists.get(B).add(A);
            linked[A][B] = linked[B][A] = true;
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(lists.get(i));
        }

        for (int i = 1; i < N+1; i++) {
//            System.out.println(i + " : " + lists.get(i).size());
            if (lists.get(i).size() >= K - 1) {
                recur(i, 0);
                visit[i] = true;
            }
        }
        System.out.println(-1);
    }

    static void recur(int n, int depth) {
        visit[n] = true;
        answer[depth] = n;
        for (int i = 0; i < depth - 1; i++) {
//            System.out.println(Arrays.toString(answer) + " " + depth);
            if (!linked[n][answer[i]]) {
                visit[n] = false;
                return;
            }

        }

        if (depth == K - 1) {
            for (int i = 0; i < depth + 1; i++) {
                System.out.println(answer[i]);
            }
            System.exit(0);
            return;
        }

        for (int next : lists.get(n)) {
//            System.out.println(Arrays.toString(visit));
            if (visit[next] || lists.get(next).size() < K - 1) {
                continue;
            }
            recur(next, depth + 1);
        }
        visit[n] = false;
    }
}
