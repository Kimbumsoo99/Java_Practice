package baekjoon.algorithm.sliding_window.p11003;
import java.io.*;
import java.util.*;
public class TimeOut {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 1;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.data - o2.data);
        ArrayDeque<Node> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        // TODO 1. N^2의 결과가 나오면 안됨.
        while (end <= N) {
            Node input = new Node(end, arr[end]);
            dq.offer(input);
            pq.offer(input);
            if (end > L) {
                Node po = dq.pollFirst();
                while (pq.peek().idx <= po.idx) {
                    pq.poll();
                }
            }
            end++;
            sb.append(pq.peek().data).append(" ");
        }
        System.out.println(sb);
    }
}
class Node{
    int idx;
    int data;

    Node(int idx, int data) {
        this.idx = idx;
        this.data = data;
    }
}
