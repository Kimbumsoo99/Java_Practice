package baekjoon.data_structure.queue.implementation2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue q = new Queue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String operations = st.nextToken();
            if (operations.equals("push")) {
                q.push(Integer.parseInt(st.nextToken()));
            } else if (operations.equals("pop")) {
                sb.append(q.pop()).append("\n");
            } else if (operations.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (operations.equals("empty")) {
                sb.append(q.empty()).append("\n");
            } else if (operations.equals("front")) {
                sb.append(q.front()).append("\n");
            } else if (operations.equals("back")) {
                sb.append(q.back()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
