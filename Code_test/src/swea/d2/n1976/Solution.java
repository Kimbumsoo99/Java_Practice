package swea.d2.n1976;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int AH = sc.nextInt();
            int AM = sc.nextInt();
            int BH = sc.nextInt();
            int BM = sc.nextInt();

            int H = AH + BH;
            int M = AM + BM;
            H += M/60;
            M %= 60;
            H %= 12;
            if(H==0) H=12;
            System.out.println("#"+test_case+" "+H+" " +M);
        }
    }
}
