package baekjoon.queue.card1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayDeque<Integer> dq = new ArrayDeque();
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int tmp = dq.pollFirst();
            sb.append(tmp + " ");
            if(dq.isEmpty()) break;
            int tmp2 = dq.pollFirst();
            dq.offer(tmp2);
        }

        System.out.println(sb);
    }

}
