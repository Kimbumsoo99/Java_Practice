package baekjoon.data_structure.priority_queue.g1744;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 반례 보고 풀음
// 골드 4, 수 묶기
public class Main {

    static class Node implements Comparable<Node> {
        int num;

        Node(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Node n) {
            return n.num - this.num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            if (tmp > 0) {
                pq.offer(new Node(tmp));
            }else{
                minusQ.offer(tmp);
            }
        }
        ArrayList<Integer> rest = new ArrayList<>();

        while (pq.size() > 1) {
            int A = pq.poll().num;
            int B = pq.poll().num;
            if (A * B > A + B) {
                rest.add(A * B);
            } else {
                rest.add(A);
                pq.offer(new Node(B));
            }
        }
        if (!pq.isEmpty()) {
            rest.add(pq.poll().num);
        }

        while (minusQ.size() > 1) {
            int A = minusQ.poll();
            int B = minusQ.poll();
            if (A * B >= A + B) {
                rest.add(A * B);
            } else {
                rest.add(A);
                minusQ.offer(B);
            }
        }
        if (!minusQ.isEmpty()) {
            rest.add(minusQ.poll());
        }

        int sum = 0;
        for (Integer r : rest) {
            sum += r;
        }
        System.out.println(sum);
    }
}
