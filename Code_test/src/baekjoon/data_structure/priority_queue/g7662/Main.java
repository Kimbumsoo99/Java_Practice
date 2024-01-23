package baekjoon.data_structure.priority_queue.g7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            map = new HashMap<>(); // 수, count
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                // I 는 숫자 삽입
                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    maxQ.offer(num);
                    minQ.offer(num);
                }
                // D 1 은 최대, D -1은 최소값 삭제
                else{
                    // Q가 비었을 때 D는 무시
                    if(map.isEmpty()){
                        continue;
                    }
                    if(num == 1){
                        delete(maxQ);
                    }else{
                        delete(minQ);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                int max = 0;
                int min = 0;
                while (!map.containsKey(maxQ.peek())) {
                    maxQ.poll();
                }
                while (!map.containsKey(minQ.peek())) {
                    minQ.poll();
                }
                max = maxQ.poll();
                min = minQ.poll();
                System.out.println(max + " " + min);
            }
        }
    }

    static void delete(PriorityQueue<Integer> pq){
        while (true) {
            int po = pq.poll();

            if (map.containsKey(po)) {
                int tmp = map.put(po, map.get(po) - 1);
                if (tmp == 1) {
                    map.remove(po);
                }
                break;
            }
        }
    }
}