package baekjoon.implementations.bronze.basket_ball_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

// 농구 경기, 브 II, 1159번
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine().substring(0, 1);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        Iterator<String> it = map.keySet().iterator();
        ArrayList<String> list = new ArrayList<>();
        while (it.hasNext()) {
            String tmp = it.next();
            if (map.get(tmp) > 4) {
                list.add(tmp);
            }
        }
        if (list.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }

}
