package baekjoon.data_structure.priority_queue.s11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int abs;
        int value;
        Node(int value){
            this.abs = Math.abs(value);
            this.value = value;
        }
        @Override
        public int compareTo(Node n){
            return this.abs == n.abs ? this.value - n.value : this.abs - n.abs;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0){
                if (pq.isEmpty()) {
                    sb.append(0);
                }else{
                    sb.append(pq.poll().value);
                }
                sb.append("\n");
            }else{
                pq.offer(new Node(cmd));
            }
        }
        System.out.println(sb);
    }
}
