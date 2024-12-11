package baekjoon.algorithm.bit_masking.s1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < 7; i++) {
            count += N % 2;
            N >>= 1;
        }
        System.out.println(count);
    }
}
