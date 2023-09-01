package baekjoon.implementations.gold.villain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[][] segment = {
        {1, 1, 1, 1, 1, 1, 0},  // 0
        {0, 1, 1, 0, 0, 0, 0},  // 1
        {1, 1, 0, 1, 1, 0, 1},  // 2
        {1, 1, 1, 1, 0, 0, 1},  // 3
        {0, 1, 1, 0, 0, 1, 1},  // 4
        {1, 0, 1, 1, 0, 1, 1},  // 5
        {1, 0, 1, 1, 1, 1, 1},  // 6
        {1, 1, 1, 0, 0, 0, 0},  // 7
        {1, 1, 1, 1, 1, 1, 1},  // 8
        {1, 1, 1, 1, 0, 1, 1}   // 9
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1층부터 N층까지 존재
        int K = Integer.parseInt(st.nextToken()); // Display 표현 방식 3 -> 001층, 002층
        int P = Integer.parseInt(st.nextToken()); // 반전 가능 개수
        int X = Integer.parseInt(st.nextToken()); // 현재 층수

        // 현재 층수에서 반전 가능 개수를 다 소모하지 않고 만들 수 있는 수를 찾아라.
        // 1 ~ N까지 현재 층수를 제외한 브루트포스 탐색.
        String current = returnStrNum(X, K);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            String loopNum = returnStrNum(i, K);
            if (solution(current, loopNum, P)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean solution(String current, String compare, int led){
//        System.out.println(current + " " + compare + " " + led);
        int length = current.length();
        for (int i = 0; i < length; i++) {
            int num1 = Integer.parseInt(current.substring(i, i + 1));
            int num2 = Integer.parseInt(compare.substring(i, i + 1));
            if (num1 == num2) {
                continue;
            }
//            System.out.println("Number " + num1 + " " + num2);

            for (int j = 0; j < 7; j++) {
                if (segment[num1][j] != segment[num2][j]) {
                    led--;
                    if (led < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static String returnStrNum(int num, int K){
        String current = String.valueOf(num);
        while (current.length() < K){
            current = '0' + current;
        }
        return current;
    }
}

/*
  1
6   2
  7
5   3
  4
 */