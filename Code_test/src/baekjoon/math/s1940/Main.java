package baekjoon.math.s1940;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        boolean[] ok = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = 0;
        int sum;
        int count = 0;
        while (idx < N) {
            sum = arr[idx];
            if (ok[idx]) {
                idx++;
                continue;
            }
            for (int i = idx + 1; i < N; i++) {
                if (!ok[i] && sum + arr[i] == M) {
                    ok[idx] = true;
                    ok[i] = true;
                    count++;
                    break;
                }
            }
            idx++;
        }
        System.out.println(count);
    }

}
