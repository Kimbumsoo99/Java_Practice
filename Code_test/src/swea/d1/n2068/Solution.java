package swea.d1.n2068;

import java.util.Scanner;
import java.io.FileInputStream;
// 2068. 최대수 구하기
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int max =Integer.MIN_VALUE;
            for(int i=0;i<10;i++){
                int tmp = sc.nextInt();
                max = Math.max(max, tmp);
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}