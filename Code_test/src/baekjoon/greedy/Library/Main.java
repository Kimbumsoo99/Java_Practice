package baekjoon.greedy.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 참고해서 풀은 문제이다.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp < 0) {
                minus.add(tmp);
            } else {
                plus.add(tmp);
            }
        }
        Collections.sort(minus); // [-36, -34, -9]
        Collections.sort(plus, Collections.reverseOrder()); // [12, 10, 4]
//        System.out.println(minus);
//        System.out.println(plus);
        int move = 0;
        int max = 0;

        while (!minus.isEmpty()) {
            int tmp = -minus.remove(0);
            for (int i = 1; i < M; i++) {
                if (!minus.isEmpty()) {
                    minus.remove(0);
                } else {
                    break;
                }
            }
            if (max < Math.abs(tmp)) {
                max = tmp;
            }
            move += tmp;
//            System.out.println(move + " " + tmp + " " + minus.size());
        }

        while (!plus.isEmpty()) {
            int tmp = plus.remove(0);
            for (int i = 1; i < M; i++) {
                if (!plus.isEmpty()) {
                    plus.remove(0);
                } else {
                    break;
                }
            }
            if (max < tmp) {
                max = tmp;
            }
            move += tmp;
//            System.out.println(move + " " + tmp + " " + plus.size());
        }

        move *= 2;
        move -= max;
        System.out.println(move);
    }

}
