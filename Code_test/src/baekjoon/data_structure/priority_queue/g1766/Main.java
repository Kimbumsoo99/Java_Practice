package baekjoon.data_structure.priority_queue.g1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] count;
    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        count = new int[N + 1];
        lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            count[B]++;
            lists[A].add(B);
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            if (count[i] == 0)
                pQueue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pQueue.isEmpty()) {
            int tmp = pQueue.poll();
            sb.append(tmp + " ");
            for (int next : lists[tmp]) {
                if (--count[next] == 0)
                    pQueue.offer(next);
            }
        }
        System.out.println(sb);
    }
}
