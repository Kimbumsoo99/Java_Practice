package baekjoon.data_structure.priority_queue.s2075;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = null;
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0;i<n-1;i++){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}