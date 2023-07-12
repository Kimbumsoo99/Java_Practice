package baekjoon.math.factorial_zero_count;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static void fact(int N){
        if(N == 0) return;
        int tmp = N;
        while (tmp % 5 == 0){
            tmp /= 5;
            map.put(5, map.getOrDefault(5, 0) + 1);
        }
        while (tmp % 2 == 0){
            tmp /= 2;
            map.put(2, map.getOrDefault(2, 0) + 1);
        }
        fact(N-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fact(N);

        int count = Math.min(map.getOrDefault(2, 0), map.getOrDefault(5, 0));
        System.out.println(count);
    }
}
