package baekjoon.implementations.silver.s1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// 알바생 강호, 실버 IV, 1758번 문제
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long tip = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int money = Integer.parseInt(br.readLine());
            list.add(money);
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            int tmp = list.get(i - 1) - (i - 1);
            tmp = tmp < 0 ? 0 : tmp;
            tip = tip + tmp;
        }
        System.out.println(tip);
    }
}
