package baekjoon.implementations.silver.s17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<int[]> stack = new Stack<>();
        int score = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int subject = Integer.parseInt(st.nextToken());
            if (subject == 0) {
                // 단순히 과제 수행
                if (stack.isEmpty()) {
                    continue;
                } else {
                    int tmp[] = stack.pop();
                    tmp[1]--;
                    if (tmp[1] == 0) {
                        score += tmp[0];
                    } else {
                        stack.push(tmp);
                    }
                }
            } else {
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                stack.push(new int[]{A, T});

                int tmp[] = stack.pop();
                tmp[1]--;
                if (tmp[1] == 0) {
                    score += tmp[0];
                }else{
                    stack.push(tmp);
                }
            }
        }
        System.out.println(score);
    }
}
