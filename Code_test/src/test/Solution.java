package test;
// SWEA 문제 테스트

import java.io.FileInputStream;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            ArrayList<Integer> box = new ArrayList<>();
            for(int i = 0;i<100;i++){
                int tmp = sc.nextInt();
                box.add(tmp);
            }
            Collections.sort(box);
            for (int i = 0; i < N; i++) {
                box.set(0, box.get(0) + 1);
                box.set(99, box.get(99) - 1);
                Collections.sort(box);
            }
            int answer = box.get(99) - box.get(0);
            System.out.println("#"+ test_case+" " + answer);

        }
    }
}