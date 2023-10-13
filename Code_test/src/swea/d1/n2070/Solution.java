package swea.d1.n2070;

import java.util.Scanner;
import java.io.FileInputStream;
// 큰놈, 작은놈,같은놈 D1
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] n = new int[T];

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            char a = '=';
            if(N>M) a = '>';
            if(N<M) a = '<';
            System.out.println("#"+test_case+" "+a);
        }
    }
}