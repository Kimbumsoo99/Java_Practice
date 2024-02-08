package swea.d4.n1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        HashMap<Character, Character> close = new HashMap<>();
        close.put('>', '<');
        close.put(')', '(');
        close.put('}', '{');
        close.put(']', '[');
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            stack = new Stack<>();
            String bracket = br.readLine();
            boolean flag = false;
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < bracket.length(); i++) {
                char b = bracket.charAt(i);
                if (close.containsKey(b)) { // 닫는 괄호
                    if (stack.isEmpty()) {
                        flag = true;
                        sb.append(0).append("\n");
                        break;
                    } else if (stack.peek() != close.get(b)) { // 괄호가 안맞음
                        flag = true;
                        sb.append(0).append("\n");
                        break;
                    }
                    stack.pop();
                } else { // 여는 괄호
                    stack.push(b);
                }
            }
            if (!flag) { // 결과가 안나왔다면
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}
