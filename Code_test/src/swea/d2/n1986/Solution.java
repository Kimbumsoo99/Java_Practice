package swea.d2.n1986;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        boolean flag = true;
        int arr[] = new int[11];
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (flag) {
                sum += i;
            } else {
                sum -= i;
            }
            arr[i] = sum;
            flag = !flag;
        }
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            System.out.println("#" + test_case + " " + arr[N]);
        }
    }
}