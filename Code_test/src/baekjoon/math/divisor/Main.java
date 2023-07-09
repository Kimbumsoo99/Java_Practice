package baekjoon.math.divisor;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 1037번
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[2];
        num[0] = Integer.MAX_VALUE;
        num[1] = 1;

        for(int i=0;i<N;i++){
            int m = sc.nextInt();
            num[0] = Math.min(num[0], m);
            num[1] = Math.max(num[1], m);
        }

        System.out.println(num[0] * num[1]);
    }
}
