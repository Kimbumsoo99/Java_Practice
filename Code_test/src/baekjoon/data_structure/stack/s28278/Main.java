package baekjoon.data_structure.stack.s28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int num;
            if (cmd == 1) {
                num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (cmd == 2) {
                sb.append(stack.isEmpty() ? -1 : stack.pop());
            } else if (cmd == 3) {
                sb.append(stack.size());
            } else if (cmd == 4) {
                sb.append(stack.isEmpty() ? 1 : 0);
            } else {
                sb.append(stack.isEmpty() ? -1 : stack.peek());
            }
            if (cmd > 1) {
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}