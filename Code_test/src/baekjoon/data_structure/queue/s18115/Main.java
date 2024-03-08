package baekjoon.data_structure.queue.s18115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int turn[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        turn = new int[N];
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            turn[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int num = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (turn[i] == 1) {
                dq.offerFirst(num++);
            } else if (turn[i] == 2) {
                int tmp = dq.poll();
                dq.offerFirst(num++);
                dq.offerFirst(tmp);
            } else {
                dq.offer(num++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Integer integer : dq) {
            sb.append(integer + " ");
        }
        System.out.println(sb);

    }
}
