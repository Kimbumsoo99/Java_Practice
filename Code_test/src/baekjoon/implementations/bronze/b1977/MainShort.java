package baekjoon.implementations.bronze.b1977;

import java.util.Scanner;

public class MainShort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = (int) Math.sqrt(N); i <= (int) Math.sqrt(M); i++) {
            int num = i * i;
            if (num >= N && num <= M) {
                if (min == Integer.MAX_VALUE) {
                    min = num;
                }
                sum += (num);
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
