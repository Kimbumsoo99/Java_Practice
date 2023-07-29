package baekjoon.implementations.bronze.b1977;

import java.util.Scanner;

// 완전제곱수 문제
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = N; i < M + 1; i++) {
            int tmp = (int) Math.sqrt(i);
            if (tmp * tmp == i) {
                min = Math.min(min, i);
                sum += i;
            }
        }
        if (sum == 0) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(min);
        }
        System.out.println(sb);
    }
}
