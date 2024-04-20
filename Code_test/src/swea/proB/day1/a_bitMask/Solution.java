package swea.proB.day1.a_bitMask;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 비트 마스킹 실습 (시뮬레이션)
 * 1288번 새로운 불면증 치료법
 *
 * 후기 : 문제 좀 제대로 못읽고, 노트북 환경으로 풀려하니까 제 실력에 반도 안나오는 듯.
 * 집중해보자.
 */

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int flag = (1 << 10) - 1;
            int cnt = 0;
            while (flag != 0){
                int num = N * ++cnt;
                int flagNum = 0;
                while(num != 0){
                    flagNum = (flagNum | (1 << (num % 10)));
                    num /= 10;
                }
                flag = flag - (flag & (flagNum));
            }
            System.out.printf("#%d %d\n", test_case, N * cnt);
        }
    }
}
