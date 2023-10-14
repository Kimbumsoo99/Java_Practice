package swea.d3.n1240;

import java.util.*;
import java.io.FileInputStream;
// 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
class Solution
{
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        init();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();

            String[] code = new String[N];
            for(int i=0;i<N;i++){
                code[i] = sc.next();
            }
            boolean flag = false;
            String codeNum = "";
            for(int i=0;i<N;i++){
                for(int j=M-1;j>=6;j--){
                    if(code[i].charAt(j) == '1'){
                        codeNum = code[i].substring(j-55, j+1);
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            // System.out.println(codeNum + "\n" + codeNum.length());
            int codeArr[] = new int[8];
            int encoding = 0;
            int hol = 0;
            int jjack = 0;
            for(int i =0;i<8;i++){
                codeArr[i] = map.get(codeNum.substring(i*7, i*7+7));
                if(i%2==0){
                    hol+=codeArr[i];
                }else jjack += codeArr[i];

            }
            encoding = hol * 3 + jjack;
            int answer = 0;
            if(encoding%10 == 0){
                for(int i=0;i<8;i++){
                    answer += codeArr[i];
                }
            }
            System.out.println("#"+test_case + " " +answer);

        }
    }
    static void init(){
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);
    }
}