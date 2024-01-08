package baekjoon.math.s2018;

import java.util.Scanner;

// 알고리즘 코테 문제 추천, 투 포인터
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int startIndex = 0;
        int endIndex = 1;
        int sum = endIndex;
        while (endIndex < N) {
            if (sum == N) {
                endIndex++;
                sum += endIndex;
                count++;
            } else if (sum > N) {
                startIndex++;
                sum -= startIndex;
            } else {
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(count);
    }

}
