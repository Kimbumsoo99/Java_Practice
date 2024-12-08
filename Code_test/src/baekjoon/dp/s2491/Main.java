package baekjoon.dp.s2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int up = 1;
        int down = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                up++;
            } else {
                up = 1;
            }

            if (arr[i] <= arr[i - 1]) {
                down++;
            } else {
                down = 1;
            }

            max = Math.max(max, Math.max(up, down));
        }

        System.out.println(max);
    }
}
