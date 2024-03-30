package baekjoon.algorithm.knapsack.g1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Jewel{
    int M, V;

    public Jewel(int m, int v) {
        M = m;
        V = v;
    }

    @Override
    public String toString() {
        return "Jewel{" +
                "M=" + M +
                ", V=" + V +
                '}';
    }
}
class Backpack{
    int weight;

    public Backpack(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "weight=" + weight +
                '}';
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Jewel> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (o1, o2) -> o1.M - o2.M);
        PriorityQueue<Backpack> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        PriorityQueue<Jewel> jewels = new PriorityQueue<>((o1, o2) -> o2.V - o1.V);

        for (int i = 0; i < K; i++) {
            pq.offer(new Backpack(Integer.parseInt(br.readLine())));
        }
        long answer = 0;
        int last = 0;
        while (!pq.isEmpty()) {
            Backpack tmp = pq.poll();
            while (last < list.size()) {
                Jewel j = list.get(last);
                if (tmp.weight >= j.M) {
                    last++;
                    jewels.offer(j);
                }else{
                    break;
                }
            }
            if (!jewels.isEmpty()) {
                answer += jewels.poll().V;
            }
        }
        System.out.println(answer);
    }
}
