package baekjoon.algorithm.two_pointer.s2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = i == 0 ? arr[i] : sum[i - 1] + arr[i];
        }

        int count = 0;
        for (int i = 0, j = 0; i < N; i++) {
            while (sum[i] - sum[j] + arr[j] >= M) {
                if (sum[i] - sum[j] + arr[j] == M) {
//                    System.out.println(i + " " + j);
                    count++;
                }
                if (i == j) {
                    break;
                }
                j++;
            }
        }
        System.out.println(count);
    }
}