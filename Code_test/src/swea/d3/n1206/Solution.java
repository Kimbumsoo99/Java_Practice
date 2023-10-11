package swea.d3.n1206;

import java.util.Scanner;
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
            ArrayList<Integer> list = new ArrayList<>();
            int N = sc.nextInt();
            int dx[] = new int[]{-2, -1, 1, 2};
            for(int i=0;i<N;i++){
                int tmp = sc.nextInt();
                list.add(tmp);
            }
            int answer = 0;
            for(int i=2;i<N-2;i++){
                int tmp = list.get(i);
                boolean heightFlag = true;
                int max = -1;
                for(int j=0;j<4;j++){
                    int nextX = i + dx[j];
                    if(tmp <= list.get(nextX)){
                        heightFlag = false;
                    }else{
                        max = max < list.get(nextX) ? list.get(nextX) : max;
                    }
                }
                if(heightFlag){
                    answer += (tmp - max);
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }
}