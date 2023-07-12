package baekjoon.math.prime_number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static boolean isPrime(int num){
        if(num < 2) return false;
        int tmp = (int) Math.sqrt(num);
        for (int j = 2; j < tmp + 1; j++) {
            if(num % j == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = A; i < B+1; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }
        System.out.println(sb);
    }
}
