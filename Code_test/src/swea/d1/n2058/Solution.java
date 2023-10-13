package swea.d1.n2058;

import java.util.Scanner;
import java.io.FileInputStream;
// 2058. 자릿수 더하기
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 1; test_case++)
        {
            String[] number=  sc.next().split("");
            int answer= 0;
            for(String n : number){
                answer += Integer.parseInt(n);
            }
            System.out.println(answer);

        }
    }
}