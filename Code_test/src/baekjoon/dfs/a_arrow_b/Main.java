package baekjoon.dfs.a_arrow_b;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        visit = new boolean[M + 1];
        int answer = bfs(N, M);
        if (N == M) {
            System.out.println(0);
            return;
        } else {
            System.out.println(answer);
        }
//        for (int i = 0; i < M + 1; i++) {
//            System.out.println(i + " " + dp[i]);
//        }
    }

    private static int bfs(int n, int m) {
        ArrayDeque<long[]> dq = new ArrayDeque<>();
        dq.offer(new long[]{n, 1});
        visit[n] = true;
        while (!dq.isEmpty()) {
            long[] tmp = dq.pollFirst();
            for (int i = 0; i < 2; i++) {
                long next = tmp[0];
                if (i == 0) {
                    next *= 2;
                } else {
                    next *= 10;
                    next++;
                }

                if (next > m) {
                    continue;
                } else if (next == m) {
                    return (int) (tmp[1] + 1);
                } else {
                    int temp = (int) next;
                    if (!visit[temp]) {
                        visit[temp] = true;
                        dq.offer(new long[]{next, tmp[1] + 1});
                    }
                }
            }
        }
        return -1;
    }
}

