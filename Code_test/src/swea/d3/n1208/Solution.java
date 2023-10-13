package swea.d3.n1208;

import java.io.FileInputStream;
import java.util.*;

/**
 * Flatten 문제 - 자체 피드백
 * 1. Collections.sort() 쓰는 거 너무 맘에 안든다. 시간복잡도 적으로 되게 안좋을 것 같음.
 *
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            ArrayList<Integer> box = new ArrayList<>();
            for(int i = 0;i<100;i++){
                int tmp = sc.nextInt();
                box.add(tmp);
            }
            Collections.sort(box);
            for(int i=0;i<N;i++){
                box.set(0, box.get(0)+1);
                box.set(99, box.get(99)-1);
                Collections.sort(box);
            }
            int answer = box.get(99) - box.get(0);
            System.out.println("#"+ test_case+" " + answer);

        }
    }
}