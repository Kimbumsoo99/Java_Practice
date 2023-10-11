package swea.d1.n2072;
import java.util.Scanner;
// 홀수만 더하기 문제ㅇ
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;
            for(int i=0;i<10;i++){
                int N = sc.nextInt();
                if(N%2==1) answer+=N;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
