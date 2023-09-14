package baekjoon.implementations.bronze.b17263;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            if (max < tmp) {
                max = tmp;
            }
        }
        System.out.println(max);
    }

}
