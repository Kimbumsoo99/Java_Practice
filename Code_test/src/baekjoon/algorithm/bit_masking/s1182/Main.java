package baekjoon.algorithm.bit_masking.s1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 1; i < Math.pow(2, N); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
            }
            if (sum == M) {
                count++;
            }
        }
        System.out.println(count);
    }
}
