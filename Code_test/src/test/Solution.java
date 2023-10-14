package test;
// SWEA 문제 테스트
import java.util.*;
import java.io.FileInputStream;

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
            System.out.println("#"+test_case);

            String[] code = new String[N];
            for(int i=0;i<N;i++){
                code[i] = sc.next();
            }
            boolean flag = false;
            int[] start = new int[2];
            for(int i=0;i<N;i++){
                for(int j=0;j<M-7;j++){
                    String tmp = code[i].substring(j, j+7);
                    if(map.containsKey(tmp)){
                        start[0] = i;
                        start[1] = j;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            int[] codeNum = new int[8];
            for(int i=0;i<8;i++){
                if (!map.containsKey(code[start[0]].substring(start[1], start[1] + 7))) {
                    codeNum[i] = -1;
                } else {
                    codeNum[i] = map.get(code[start[0]].substring(start[1], start[1]+7));
                }
                System.out.print(codeNum[i] + " ");
                start[1] += 7;
            }
            System.out.println();
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