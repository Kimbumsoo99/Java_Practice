package baekjoon.implementations.bronze.receipt;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        for (int i = 0; i < 9; i++) {
            int tmp = sc.nextInt();
            sum -= tmp;
        }
        System.out.println(sum);
    }
}
