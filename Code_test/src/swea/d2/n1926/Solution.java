package swea.d2.n1926;

import java.util.*;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=1;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            HashSet<Character> set = new HashSet<>();
            set.add('3');
            set.add('6');
            set.add('9');

            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=N;i++){
                String tmp = String.valueOf(i);
                int count = 0;
                for(char c : tmp.toCharArray()){
                    if(set.contains(c)){
                        count ++;
                    }
                }
                if(count >0){
                    for(int j=0;j<count;j++){
                        sb.append("-");
                    }
                    sb.append(" ");
                }else{
                    sb.append(tmp).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}