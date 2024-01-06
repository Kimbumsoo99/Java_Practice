package swea.d3.n1989;

import java.util.Scanner;
class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String tmp = sc.next();
            int N = tmp.length();
            boolean flag = true;
            int j = N - 1;
            for (int i = 0; i < N / 2; i++) {
                if (tmp.charAt(i) != tmp.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + (flag ? 1 : 0));
        }
    }
}