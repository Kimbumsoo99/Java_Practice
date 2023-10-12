package swea.d2.n1204;

import java.util.Scanner;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            int testCase = sc.nextInt();
            int maxCount = 0;
            for(int i=0;i<1000;i++){
                int score = sc.nextInt();
                countMap.put(score, countMap.getOrDefault(score, 0) + 1);
                if(maxCount < countMap.get(score)) {
                    maxCount = countMap.get(score);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            Iterator<Integer> it = countMap.keySet().iterator();
            while(it.hasNext()){
                int tmp = it.next();
                if(maxCount == countMap.get(tmp)) list.add(tmp);
            }
            Collections.sort(list, Collections.reverseOrder());
            System.out.printf("#%d %d%n", testCase, list.get(0));

        }
    }
}