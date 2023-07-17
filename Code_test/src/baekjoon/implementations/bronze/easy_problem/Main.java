package baekjoon.implementations.bronze.easy_problem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = solution(N, M);
        System.out.println(answer);

    }

    static int solution(int N, int M){
        int sum = 0;

        int count = 1;
        int idx = 0;
        for (int i = 1; i < M+1; i++) {
            for (int j = 0; j < count; j++) {
                if(++idx >= N) sum += i;
//                System.out.println(i + " " + sum);
                if(idx == M) return sum;
            }
            count ++;
        }
        return 0;
    }
}
