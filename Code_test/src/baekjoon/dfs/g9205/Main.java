package baekjoon.dfs.g9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int home[], festival[], N;
    static ArrayList<int[]> store = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            N = Integer.parseInt(br.readLine()); // 편의점 개수
            st = new StringTokenizer(br.readLine());
            home = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            store = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                store.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
            }
            st = new StringTokenizer(br.readLine());
            festival = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

            System.out.println(bfs());
        }

    }

    static String bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(home);
        boolean[] visit = new boolean[N];
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (Math.abs(festival[0] - tmp[0]) + Math.abs(festival[1] - tmp[1]) <= 1000) {
                return "happy";
            }

            for (int i = 0; i < store.size(); i++) {
                if (!visit[i]) {
                    int[] s = store.get(i);
                    int length = Math.abs(s[0] - tmp[0]) + Math.abs(s[1] - tmp[1]);
                    if (length <= 1000) {
                        dq.offer(store.get(i));
                        visit[i] = true;
                    }
                }
            }

        }

        return "sad";
    }
}

