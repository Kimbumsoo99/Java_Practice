package baekjoon.implementations.silver.bestseller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        String answer = "";
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (max < map.get(tmp)) {
                max = map.get(tmp);
                answer = tmp;
            } else if (max == map.get(tmp)) {
                answer = answer.compareTo(tmp) > 0 ? tmp : answer; // tmp 가 사전순으로 앞서면 1 반환
            }
        }
        System.out.println(answer);
    }

}
