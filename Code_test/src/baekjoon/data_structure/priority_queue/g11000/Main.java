package baekjoon.data_structure.priority_queue.g11000;
// 강의실 배정, 골드 5
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> endPQ = new PriorityQueue<>();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(new int[] {A, B});
        }
        Collections.sort(list, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        endPQ.offer(list.get(0)[1]);
        for (int i = 1; i < N; i++) {
            if(endPQ.peek() <= list.get(i)[0]) {
                endPQ.poll();
            }
            endPQ.offer(list.get(i)[1]);
        }
        System.out.println(endPQ.size());
    }
}
