package baekjoon.algorithm.recursive.s1914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(BigInteger.TWO.pow(N).subtract(BigInteger.ONE));
        if (N > 20) {
            return;
        }
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    static void hanoi(int N, int start, int sub, int end) {
        if (N == 1) {
            move(1, start, end);
            return;
        } else {
            hanoi(N - 1, start, end, sub);
            move(N, start, end);
            hanoi(N - 1, sub, start, end);
        }
    }

    static void move(int N, int start, int end) {
        sb.append(start).append(" ").append(end).append("\n");
    }
}
