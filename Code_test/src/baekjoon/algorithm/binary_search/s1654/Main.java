package baekjoon.algorithm.binary_search.s1654;

import java.util.Scanner;

public class Main {
    static int max = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        int K = sc.nextInt();
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long lo = 0;
        long hi = max;
        hi++;
        long mid = 0;
        while (lo < hi) {
            mid = (lo + hi) / 2;

            long count = 0;
            for (int i = 0; i < N; i++) {
                count += arr[i] / mid;
            }

            if (count < K) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }
}
