package baekjoon.implementations.gold.nge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (stack.empty()) {
                stack.push(new int[]{i, num}); // index, num
                continue;
            }

            while (!stack.isEmpty() && num > stack.peek()[1]) {
                int tmp[] = stack.pop();
                answer[tmp[0]] = num;
            }

            stack.push(new int[]{i, num});
        }

        while (!stack.empty()) {
            int tmp[] = stack.pop();
            answer[tmp[0]] = -1;
        }

        for (int i : answer) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}
