package baekjoon.implementations.bronze.not_cute;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map.put(0, 0);
        map.put(1, 0);
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            map.put(tmp, map.get(tmp) + 1);
        }

        if(map.get(0) > map.get(1)){
            System.out.println("Junhee is not cute!");
        }
        else{
            System.out.println("Junhee is cute!");
        }
    }
}
