package baekjoon.algorithm.topology_sort.g2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N + 1];
        int[] cost = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            for (int j = 1; j < K; j++) {
                int next = Integer.parseInt(st.nextToken());
                list[pre].add(next);
                cost[next]++;
                pre = next;
            }
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (cost[i] == 0) {
                dq.offer(i);
            }
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            cnt++;
            sb.append(cur).append("\n");
            visit[cur] = true;
            for (int next : list[cur]) {
                if (--cost[next] == 0) {
                    dq.offer(next);
                }
            }
        }

        if (cnt == N) {
            System.out.println(sb);
        } else {
            System.out.println(0);
        }

    }
}
