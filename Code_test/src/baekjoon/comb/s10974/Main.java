package baekjoon.comb.s10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 1; i < N + 1; i++) {
            arr[i - 1] = i;
        }
        do {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        } while (np(arr));
        System.out.println(sb);
    }
    static boolean np(int[] p) {
        int i = N - 1;
        while (i > 0 && p[i - 1] > p[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = N - 1;
        while (p[i - 1] > p[j]) {
            j--;
        }
        swap(p, i - 1, j);
        int k = N - 1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
