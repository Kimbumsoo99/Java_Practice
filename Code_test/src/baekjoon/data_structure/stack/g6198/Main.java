package baekjoon.data_structure.stack.g6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Number{
    int idx, num;

    public Number(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Number[] arr = new Number[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Number(i, Integer.parseInt(br.readLine()));
        }
        long[] count = new long[N];
        Stack<Number> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek().num >= arr[i].num) {
                stack.push(arr[i]);
                continue;
            }

            long cnt = 0;

            while (!stack.isEmpty()) {
                Number tmp = stack.pop();
                if (tmp.num >= arr[i].num) {
                    stack.push(tmp);
                    break;
                }
                cnt++;
                cnt += count[tmp.idx];
            }

            count[i] = cnt;
            stack.push(arr[i]);
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += count[i];
        }
        System.out.println(sum);
    }
}
