package baekjoon.data_structure.stack.g2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(new int[] { Integer.parseInt(st.nextToken()), i + 1 });
        }

        int answer[] = new int[N];
        Stack<int[]> tmpSt = new Stack<>();

        while (stack.size() > 1) {
            int tmp[] = stack.pop();
            if (stack.peek()[0] > tmp[0]) {
                answer[tmp[1] - 1] = stack.peek()[1];
                while (!tmpSt.isEmpty() && stack.peek()[0] > tmpSt.peek()[0]) {
                    answer[tmpSt.pop()[1] - 1] = stack.peek()[1];
                }
            } else {
                tmpSt.push(tmp);
            }
        }

        while (!tmpSt.isEmpty()) {
            answer[tmpSt.pop()[1] - 1] = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
