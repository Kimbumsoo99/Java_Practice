package baekjoon.data_structure.hash.s11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long max = Long.MIN_VALUE;
        long maxKey = Long.MAX_VALUE;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long A = Long.parseLong(br.readLine());
            map.put(A, map.getOrDefault(A, 0) + 1);
            if(max < map.get(A)) {
                max = map.get(A);
                maxKey = A;
            } else if (max == map.get(A) && maxKey > A) {
                maxKey = A;
            }
        }
        System.out.println(maxKey);
    }
}