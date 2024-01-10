package baekjoon.solving.silver.s1850;

import java.util.Scanner;

public class Fail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        long A = Math.abs(N - M);
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < A; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }
}
