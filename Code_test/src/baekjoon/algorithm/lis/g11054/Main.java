package baekjoon.algorithm.lis.g11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int dpR[] = new int[N];
        int dpL[] = new int[N];
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dpR[j]);
                }
            }
            dpR[i] = max + 1;
        }

        for (int i = N - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dpL[j]);
                }
            }
            dpL[i] = max + 1;
        }
//        System.out.println(Arrays.toString(dpR));
//        System.out.println(Arrays.toString(dpL));
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dpL[i] + dpR[i]) {
                max = dpL[i] + dpR[i];
            }
        }
        System.out.println(max - 1);
    }
}
