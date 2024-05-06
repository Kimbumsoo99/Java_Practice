package programmers.data_structure.heap;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }

        // 그냥 만드는 경우 -> 그냥 하면 됨.
        // 2개가 있는데, 마지막 하나로 만드는 경우 -> pq.size() > 1에 걸림,
        // 그냥 없는 경우 -> pq.size() > 1에 걸림, 단, 하나가

        while(pq.size() > 1 && pq.peek() < K){
            answer++;
            int a = pq.poll();
            int b = pq.poll() * 2;
            pq.offer(a + b);
        }
        if(pq.isEmpty() || pq.peek() < K) answer = -1;
        return answer;
    }
}