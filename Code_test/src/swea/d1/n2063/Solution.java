package swea.d1.n2063;

import java.util.*;
import java.io.FileInputStream;
// 2063. 중간값 찾기 D1
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 1; test_case++)
        {
            int N = sc.nextInt();
            int[] arr= new int[N];
            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[N/2]);

        }
    }
}