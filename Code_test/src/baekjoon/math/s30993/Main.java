package baekjoon.math.s30993;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] fact = new long[16];
        for (int i = 1; i < 16; i++) {
            fact[i] = i == 1 ? 1 : fact[i - 1] * i;
        }

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(fact[N] / (fact[A] * fact[B] * fact[C]));
    }
}