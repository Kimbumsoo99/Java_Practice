package baekjoon.algorithm.greedy.s3135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int min = Math.abs(A - B);
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            min = Math.min(min, Math.abs(B - tmp) + 1);
        }
        System.out.println(min);
    }
}