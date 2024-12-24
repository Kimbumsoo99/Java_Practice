package baekjoon.math.b5543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < 3; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int A = pq.poll();
        pq.clear();
        for (int i = 0; i < 2; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        System.out.print(A + pq.poll() - 50);
    }
}