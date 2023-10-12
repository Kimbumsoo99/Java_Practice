import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Main
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
            System.out.println("testCase : " + testCase);
            int maxCount = 0;
            for(int i=0;i<1000;i++){
                int score = sc.nextInt();
                countMap.put(score, countMap.getOrDefault(score, 0) + 1);
                if(maxCount < countMap.get(score)) {
                    maxCount = countMap.get(score);
                    System.out.println(countMap.get(score) + " " + score);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            Iterator<Integer> it = countMap.keySet().iterator();
            while(it.hasNext()){
                int tmp = it.next();
                if(maxCount == countMap.get(maxCount)) list.add(tmp);
            }
            Collections.sort(list, Collections.reverseOrder());
            System.out.printf("#%d %d", testCase, list.get(0));

        }
    }
}