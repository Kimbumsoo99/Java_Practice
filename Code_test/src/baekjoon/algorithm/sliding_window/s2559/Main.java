package baekjoon.algorithm.sliding_window.s2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int idx = M;
        int max = 0;
        for (int i = 0; i < idx; i++) {
            max += arr[i];
        }

        int tmp = max;
        for (int i = idx; i < N; i++) {
            tmp = tmp - arr[i - idx] + arr[i];
            max = Math.max(max, tmp);
        }

        System.out.println(max);
    }
}