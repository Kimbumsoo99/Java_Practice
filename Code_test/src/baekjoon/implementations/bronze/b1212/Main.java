package baekjoon.implementations.bronze.b1212;

import java.util.Scanner;

// 8진수 2진수
public class Main {
    static String[] tmp = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        if (N.equals("0")) {
            System.out.println(0);
        }else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N.length(); i++) {
                if (i == 0) {
                    sb.append(Integer.parseInt(tmp[Integer.parseInt(N.substring(i, i + 1))]));
                } else
                    sb.append(tmp[Integer.parseInt(N.substring(i, i + 1))]);
            }
            System.out.println(sb);
        }
    }
}
