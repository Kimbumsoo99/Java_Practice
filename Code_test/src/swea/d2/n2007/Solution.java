package swea.d2.n2007;

import java.util.Scanner;
// 2007. 패턴 마디의 길이
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        try {
            for (int test_case = 1; test_case <= T; test_case++) {
                String tmp = sc.next();
                char start = tmp.charAt(0);
                String answer = "";
                for (int i = 1; i < tmp.length(); i++) {
                    char w = tmp.charAt(i);
                    if (start == w) {
                        if (tmp.substring(0, i).equals(tmp.substring(i, i + i))) {
                            answer = tmp.substring(0, i);
                            break;
                        }
                    }
                }
                System.out.println("#" + test_case + " " + answer.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
