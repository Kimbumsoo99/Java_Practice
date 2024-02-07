package baekjoon.dfs.g12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visit;
    static int N, M, answer = 0, count = 0;
    static int dx[] = new int[]{1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[1_000_000];
        visit = new boolean[1_000_000];
        bfs();
        System.out.println(answer);
        System.out.println(count);
    }

    static void bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{N, 0});
        int breadth = 0;
        visit[N] = true;
        boolean flag = false;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (tmp[1] != breadth) {
                breadth++;
            }

            if (!flag && tmp[0] == M) {
                flag = true;
                answer = tmp[1];
                count++;
            } else if (tmp[0] == M && answer == tmp[1]) {
                count++;
            }

            if (flag) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int next = i == 2 ? tmp[0] * 2 : tmp[0] + dx[i];
                if (isMap(next) && !visit[next]) {
                    if (breadth == tmp[1]) {
                        visit[tmp[0]] = true;
                    }
                    dq.offer(new int[]{next, tmp[1] + 1});
                }
            }
        }
    }

    static boolean isMap(int idx) {
        if (idx >= 0 && idx < (Math.max(N, M) * 2)) {
            return true;
        }
        return false;
    }
}
