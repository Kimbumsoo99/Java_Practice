package baekjoon.greedy.ship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> ship = new ArrayList<>();
    static ArrayList<Integer> box = new ArrayList<>();
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ship.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        visit = new boolean[M];
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(ship, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (ship.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (!box.isEmpty()) {
            time++;
            // idx를 활용한 부분이 핵심 풀이다!!
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = idx; j < box.size(); j++) {
                    if (ship.get(i) >= box.get(j)) {
//                        System.out.println(ship.get(i) + " " + box.get(j));
                        box.remove(j);
                        break;
                    } else {
                        idx++;
                    }
                }
            }
        }
        System.out.println(time);
    }

}
