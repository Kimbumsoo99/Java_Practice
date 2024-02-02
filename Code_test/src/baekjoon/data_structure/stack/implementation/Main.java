package baekjoon.data_structure.stack.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (operation.equals("push")) {
                stack.push(Integer.valueOf(st.nextToken()));
            } else if (operation.equals("pop")) {
                if(stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            } else if (operation.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (operation.equals("empty")) {
                if(stack.empty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (operation.equals("top")) {
                if(stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }

}
