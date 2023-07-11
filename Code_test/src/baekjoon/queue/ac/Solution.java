package baekjoon.queue.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String command = br.readLine(); // RDD 같은 명령어
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<Integer>();

            for (int j = 0; j < N; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String command, ArrayDeque<Integer> deque) {
        boolean isRight = true;
        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            // D
            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }else{
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makePrintString(deque, isRight);
    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight){
        sb.append('[');
        if(deque.size() > 0){
            if (isRight) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else{
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append("]\n");
    }
}