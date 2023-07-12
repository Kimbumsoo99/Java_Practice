package baekjoon.math.hash_algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String data = sc.next();
//            i - 96
        long answer = 0;
        long pow = 1;
        for (int i = 0; i < N; i++) {
            answer += ((int)data.charAt(i) - 96) * pow;
            pow = (pow * 31) % 1234567891;
        }
        System.out.println(answer % 1234567891);
    }

}
