package baekjoon.algorithm.divide_and_conquer.s1629;

import java.util.Scanner;

public class Main {
    static long rest = 1L;
    static long answer = 0L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        for (int i = 1; i <= B % 4; i++) {
            rest = (rest * A) % C;
        }
        recur((A * A % C) * (A * A % C) % C, B / 4, C);
        System.out.println(answer);
    }

    static void recur(long num, long count, long mod) {
        if (count < 4) {
            for (int i = 1; i <= count % 4; i++) {
                rest = (rest * num) % mod;
            }
            answer = rest;
            return;
        }

        for (int i = 1; i <= count % 4; i++) {
            rest = (rest * num) % mod;
        }
        recur((num * num % mod) * (num * num % mod) % mod, count / 4, mod);
    }
}
