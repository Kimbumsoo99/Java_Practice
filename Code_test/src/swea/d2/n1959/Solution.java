package swea.d2.n1959;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] nArr = new int[N];
            int[] mArr = new int[M];
            for (int i = 0; i < N; i++) {
                int tmp = sc.nextInt();
                nArr[i] = tmp;
            }
            for (int i = 0; i < M; i++) {
                int tmp = sc.nextInt();
                mArr[i] = tmp;
            }
            int longArr[];
            int shortArr[];
            if (N >= M) {
                longArr = nArr;
                shortArr = mArr;
            } else {
                longArr = mArr;
                shortArr = nArr;
            }

            int max = Integer.MIN_VALUE;
            int time = longArr.length - shortArr.length;
            for (int i = 0; i < time + 1; i++) {
                int tempSum = 0;
                for (int j = 0; j < shortArr.length; j++) {
                    tempSum += shortArr[j] * longArr[i + j];
                }
                max = Math.max(tempSum, max);
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}