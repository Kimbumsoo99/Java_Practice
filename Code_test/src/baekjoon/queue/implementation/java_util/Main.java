package baekjoon.queue.implementation.java_util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String operations = st.nextToken();
            if (operations.equals("push")) {
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if (operations.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else
                    sb.append(queue.remove()).append("\n");
            } else if (operations.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (operations.equals("empty")) {
                int tmp = queue.isEmpty() ? 1 : 0;
                sb.append(tmp).append("\n");
            } else if (operations.equals("front")) {
                Integer tmp = queue.peek();
                if(tmp == null) tmp = -1;
                sb.append(tmp).append("\n");
            } else if (operations.equals("back")) {
                Integer tmp = queue.peekLast();
                if(tmp == null) tmp = -1;
                sb.append(tmp).append("\n");
            }
        }
        System.out.println(sb);
    }
}
