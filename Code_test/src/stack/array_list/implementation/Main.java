package stack.array_list.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        StackImpl stack =new StackImpl();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if (oper.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (oper.equals("pop")) {
                sb.append(stack.pop()).append("\n");
            } else if (oper.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (oper.equals("empty")) {
                if (stack.empty()) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            } else if (oper.equals("top")) {
                sb.append(stack.top()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
