package baekjoon.implementations.silver.s1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 수 이어 쓰기 1, 실버 IV, 1748번
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());
        int count = 0;
        int plus = 1;
        int num = 10;
        for (int i = 1; i <= result; i++) {
            if (i % num == 0) {
                plus++;
                num *= 10;
            }
            count += plus;
        }
        System.out.println(count);
    }
}


// 틀린 풀이
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int result = Integer.parseInt(br.readLine());
//    int num = 1;
//    int answer = 0;
//        while (num <= result) {
//            int length = String.valueOf(num).length();
//            answer += length;
//            num++;
//            }
//            System.out.println(answer);