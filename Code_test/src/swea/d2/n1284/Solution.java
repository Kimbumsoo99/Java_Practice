package swea.d2.n1284;

import java.util.Scanner;
// 1284. 수도 요금 경쟁
class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int P = sc.nextInt(); // A사 1L 당 요금
            int Q = sc.nextInt(); // B사 기본 요금
            int R = sc.nextInt(); // B사 기본 요금 제한 L
            int S = sc.nextInt(); // B사 1L 당 추가 요금
            int W = sc.nextInt(); // N

            int answer = W * P; // A사 기본 요금
            int diff = W - R <= 0 ? 0 : W - R;
            if (answer > Q + ((diff) * S)) {
                answer = Q + ((diff) * S);
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}