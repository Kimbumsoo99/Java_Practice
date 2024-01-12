package baekjoon.data_structure.priority_queue.g1715;
// 카드 정렬하기, 골드 4
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long sum = 0L;
        while(pq.size() > 1) {
            int cardA = pq.poll();
            int cardB = pq.poll();
            int card = cardA+cardB;
            sum += card;
            pq.offer(card);
        }
        System.out.println(sum);
    }
}
