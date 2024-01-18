package baekjoon.backtracking.gold.g9663;

import java.util.Scanner;

public class Main {
    static int[] queen;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        queen = new int[N];
        nQueen(0, N);
        System.out.println(count);
    }

    static void nQueen(int depth, int N) {
        if(depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queen[depth] = i; // 첫 번째 행(=depth)의 몇 번재 열(=i)에 퀸 두기

            if(isQueen(depth, i, N)) { // 이번 열에 두는 것이 문제 없다면, 다음 행 퀸 찾기
                nQueen(depth+1, N);
            }
        }
    }

    static boolean isQueen(int depth, int col, int N) {
        for (int i = 0; i < depth; i++) {
            if(queen[depth] == queen[i]) return false; // 같은 열에 있는 경우
            else if(Math.abs(depth - i) == Math.abs(queen[i] - queen[depth])) return false;
        }
        return true;
    }
}
