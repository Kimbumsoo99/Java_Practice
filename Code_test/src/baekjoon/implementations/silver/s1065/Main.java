package baekjoon.implementations.silver.s1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1065번, 한수, 실버 IV 문제
// Code_test/src/baekjoon/implementations/silver/s1065/Fail.java
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            String number = String.valueOf(i);
            if(isTrue(number)) answer++;
//            if (!(number.length() < 3)) {
//                System.out.println();
//            }
        }
        System.out.println(answer);
    }

    private static boolean isTrue(String number) {
        if (number.length() < 3) {
            return true;
        }
        int start = number.charAt(0) - '0';
        int diff = (number.charAt(1) - '0') - start;

        int current = start;
        int idx = 1; // 현재 숫자 index
//        System.out.print(number + " " + diff + " : " + current + " ");
        while (idx < number.length()) {
            int next = Integer.parseInt(number.substring(idx, idx + 1));
            if (next == current + diff) {
//                System.out.print(next+ " ");
                idx++;
                current = next;
            } else {
                return false;
            }
        }
        return true;
    }
}
