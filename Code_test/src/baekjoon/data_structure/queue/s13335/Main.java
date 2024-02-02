package baekjoon.data_structure.queue.s13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken()); // 길이
        int L = Integer.parseInt(st.nextToken()); // 다리가 버티는 무게

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int time = 1;
        int weight = arr[idx];
        dq.offer(arr[idx++]);
        while (!dq.isEmpty()) {
            if (time > W) {
                weight -= dq.poll();
            }
            if (idx < N) {
                if (weight + arr[idx] <= L) {
                    weight += arr[idx];
                    dq.offer(arr[idx++]);
                } else if (dq.size() < W) {
                    dq.offer(0);
                }
            }
            time++;
        }
        System.out.println(time - 1);
    }
}
