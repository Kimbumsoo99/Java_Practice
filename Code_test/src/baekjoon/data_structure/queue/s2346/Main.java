package baekjoon.data_structure.queue.s2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Balloon> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            dq.offer(new Balloon(i, tmp));
        }

        StringBuilder sb = new StringBuilder();
        Balloon b = dq.poll();
        sb.append("1 ");
        for (int i = 1; i < N; i++) {
            if (b.next >= 0) {
                for (int j = 1; j < b.next; j++) {
                    dq.offer(dq.poll());
                }
                b = dq.poll();
                sb.append(b.idx).append(" ");

            } else {
                for (int j = 1; j < Math.abs(b.next); j++) {
                    dq.offerFirst(dq.pollLast());
                }
                b = dq.pollLast();
                sb.append(b.idx).append(" ");
            }
        }
        System.out.println(sb);
    }

    static class Balloon {
        int idx;
        int next;

        Balloon(int idx, int next) {
            this.idx = idx;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Balloon{" +
                "idx=" + idx +
                ", next=" + next +
                '}';
        }
    }
}