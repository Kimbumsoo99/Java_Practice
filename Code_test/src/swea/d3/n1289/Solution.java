package swea.d3.n1289;

import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = sc.next().toCharArray();
            char V = '0';
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (V != arr[i]) {
                    count++;
                    V = V == '0' ? '1' : '0';
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}