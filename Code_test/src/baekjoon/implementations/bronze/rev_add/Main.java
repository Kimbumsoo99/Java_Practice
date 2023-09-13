package baekjoon.implementations.bronze.rev_add;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Rev(sc.nextInt());
        int M = Rev(sc.nextInt());
        System.out.println(Rev(N + M));

    }

    static int Rev(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num).reverse();
        return Integer.parseInt(sb.toString());
    }
}
