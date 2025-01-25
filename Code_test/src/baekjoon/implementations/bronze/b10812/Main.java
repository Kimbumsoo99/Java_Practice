package baekjoon.implementations.bronze.b10812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());

            int[] tmp = Arrays.copyOfRange(arr, start, end + 1);
            for (int j = start, t = mid - start; j <= end; j++, t = (t + 1) % tmp.length) {
                arr[j] = tmp[t];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}