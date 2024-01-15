package baekjoon.data_structure.priority_queue.g1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> crane = new ArrayList<>();
    static class Box implements Comparable<Box> {
        int weight;
        Box(int weight){
            this.weight = weight;
        }
        @Override
        public int compareTo(Box b){
            return b.weight - this.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        PriorityQueue<Box> boxQ = new PriorityQueue<>();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxQ.offer(new Box(Integer.parseInt(st.nextToken())));
        }

        Collections.sort(crane);

        int time = 0;
        while (!boxQ.isEmpty()) {
            int tmp = boxQ.poll().weight;

        }
    }
}
