package baekjoon.algorithm.sieve_of_eratosthenes.prime_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        boolean flag = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(N%i == 0) flag = true;
        }
        if (flag) {
            System.out.println("소수");
        }else{
            System.out.println("소수가 아님");
        }
    }
}
