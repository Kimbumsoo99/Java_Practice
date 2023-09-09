package baekjoon.implementations.silver.s1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 한 줄로 서기, 실버 II, 1138번
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.offer(Integer.parseInt(st.nextToken()));
        }

        int count = 1;
        while (!dq.isEmpty()) {
            int tmp = dq.pollFirst();
            int idx = 0;
            while (true) {
                if (answer[idx] == 0 && tmp == 0) {
                    answer[idx] = count++;
                    break;
                } else if (answer[idx] == 0) {
                    tmp--;
                }
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
