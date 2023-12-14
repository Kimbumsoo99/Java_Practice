package baekjoon.implementations.silver.truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Truck{
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            Truck[] s = new Truck[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                s[i] = new Truck(Integer.parseInt(st.nextToken()), 0);
            }

            ArrayDeque<Truck> dq = new ArrayDeque<>();
            int time = 0;
            int currentWeight = 0;
            int idx = 0;
            while (true) {
                time++;
                if (idx >= N && dq.isEmpty()) {
                    break;
                }
                if (idx < N && currentWeight + s[idx].weight <= L) {
                    currentWeight += s[idx].weight;
                    dq.offer(s[idx++]);
                }

                for (Truck truck : dq) {
                    truck.time++;
                    if (truck.time >= W) {
                        Truck tmp = dq.pollFirst();
                        currentWeight -= tmp.weight;
                    }
                }
            }
            System.out.println(time);
        }

}
