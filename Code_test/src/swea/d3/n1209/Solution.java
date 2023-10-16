package swea.d3.n1209;

import java.util.Scanner;
// 1209. [S/W 문제해결 기본] 2일차 - Sum
class Solution
{
    static int[][] Graph;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int testCase = sc.nextInt();
            int max = 0;
            Graph = new int[100][100];
            for(int i=0;i<100;i++){
                for(int j=0;j<100;j++){
                    int tmp = sc.nextInt();
                    Graph[i][j] = tmp;
                }
            }
            int sumCol;
            int sumRow;
            for(int i=0;i<100;i++){
                sumCol = 0;
                sumRow = 0;
                for(int j=0;j<100;j++){
                    sumCol += Graph[j][i];
                    sumRow += Graph[i][j];
                }
                max = Math.max(max, Math.max(sumCol, sumRow));
            }

            int sumR=0;
            int sumL=0;
            for(int i=0,j=0;i<100;i++,j++){
                sumR += Graph[i][j];
                sumL += Graph[i][99-j];
            }
            max = Math.max(max, Math.max(sumR, sumL));
            System.out.println("#"+testCase+" "+max);
        }
    }
}