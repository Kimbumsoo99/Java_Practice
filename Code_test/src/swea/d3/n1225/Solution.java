package swea.d3.n1225;

import java.util.*;
// 1225. [S/W 문제해결 기본] 7일차 - 암호생성기
class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int testCase = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                list.add(sc.nextInt());
            }
            int count = 1;
            while (true) {
                int tmp = list.get(0);
                list.remove(0);
                tmp -= count;
                if (tmp <= 0) {
                    list.add(0);
                    break;
                } else {
                    list.add(tmp);
                }
                count = count + 1;
                if (count > 5) {
                    count = 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append(list.get(i)).append(" ");
            }
            System.out.println("#" + testCase + " " + sb);
        }
    }
}
