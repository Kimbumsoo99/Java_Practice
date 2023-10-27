package swea.d3.n6190;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 정곤이의 단조 증가하는 수, D3 난이도
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            ArrayList<Integer> numList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int tmp = sc.nextInt();
                numList.add(tmp);
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < numList.size(); i++) {
                for (int j = 0; j < numList.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    int tmp = numList.get(i) * numList.get(j);
                    if (isOk(tmp)) {
                        list.add(tmp);
                    }
                }
            }

            int answer;
            if (list.size() > 0) {
                Collections.sort(list);
                answer = list.get(list.size() - 1);
            } else {
                answer = -1;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static boolean isOk(int n) {
        String numStr = String.valueOf(n);
        int tmp = numStr.charAt(0) - '0';
        for (int i = 1; i < numStr.length(); i++) {
            if (tmp > numStr.charAt(i) - '0') {
                return false;
            } else {
                tmp = numStr.charAt(i) - '0';
            }
        }
        return true;
    }
}