package baekjoon.data_structure.stack.s3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Stack<Character> stack = null;
        for (int i = 0; i < N; i++) {
            stack = new Stack<>();
            char[] input = br.readLine().toCharArray();

            Stack<Character> diffStack = new Stack<>();

            for (int j = 0; j < input.length; j++) {
                char c = input[j];
                stack.push(c);
            }

            while (!stack.isEmpty()) {
//                System.out.println(stack + " " + diffStack);
                char c = stack.pop();
                if (!diffStack.isEmpty()) {
                    if (diffStack.peek() != c) {
                        diffStack.push(c);
                    } else {
                        diffStack.pop();
                    }
                } else {
                    diffStack.push(c);
                }
            }

            if(diffStack.isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }
}