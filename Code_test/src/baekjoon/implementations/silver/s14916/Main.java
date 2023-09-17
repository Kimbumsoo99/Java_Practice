package baekjoon.implementations.silver.s14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 거스름돈, 실버 V
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N % 5 != 0) {
            N -= 2;
            count++;
        }
        System.out.println(N);
        count += N / 5;
        if (N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

}
