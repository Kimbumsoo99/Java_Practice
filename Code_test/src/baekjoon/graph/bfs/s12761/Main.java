package baekjoon.graph.bfs.s12761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, M));
    }

    private static int bfs(int n, int m) {
        boolean[] visit = new boolean[100_001];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{n, 0});
        visit[n] = true;

        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            if (tmp[0] == m) {
                return tmp[1];
            }
            for (int i = 0; i < 8; i++) {
                int next = jump(i, tmp[0]);
                if(isMap(next) && !visit[next]) {
                    visit[next] = true;
                    dq.offer(new int[]{next, tmp[1] + 1});
                }
            }
        }

        return -1;
    }

    private static int jump(int i, int cur) {
        switch (i) {
            case 0:
                return cur - 1;
            case 1:
                return cur + 1;
            case 2:
                return cur + A;
            case 3:
                return cur + B;
            case 4:
                return cur - A;
            case 5:
                return cur - B;
            case 6:
                return cur * A;
            default:
                return cur * B;
        }
    }

    static boolean isMap(int cur){
        return cur >= 0 && cur <= 100_000;
    }
}