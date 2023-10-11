package swea.d2.n1859;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] dayPrice;
    static boolean[] pay;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            dayPrice = new int[N];
            pay = new boolean[N];
            for(int i=0;i<N;i++){
                int day = sc.nextInt();
                dayPrice[i] = day;
            }
            long answer = 0L;
            for(int i=N-1;i>=0;i--){
                if(pay[i]) continue;
                int current = dayPrice[i];
                for(int j=i-1;j>=0;j--){
                    if(!pay[j] && dayPrice[j] < current){
                        answer += current - dayPrice[j];
                        pay[j] = true;
                    }else if(dayPrice[j] >= current){
                        i=j+1;
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }

    }
}