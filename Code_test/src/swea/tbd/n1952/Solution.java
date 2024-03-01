package swea.tbd.n1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int membership[] = new int[4], monthPrice[] = new int[15], price[] = new int[15];
    static final int ONE_DAY = 0, ONE_MONTH = 1, THREE_MONTH = 2, ONE_YEAR = 3;
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T+1; test_case++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                membership[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            answer = membership[ONE_YEAR];
            for (int i = 0; i < 12; i++) {
                monthPrice[i] = Integer.parseInt(st.nextToken());
                price[i] = Math.min(monthPrice[i] * membership[ONE_DAY], membership[ONE_MONTH]);
            }
            int sum = 0;
            // 완탐, 3달을 묶어서 123을 하는 경우와 안하는 경우
            // 1. 하는 경우 +3 idx 부터 시작
            // 2. 안하는 경우 +1 부터 시작
            dfs(0, 0); // idx, sum
            sb.append("#" + test_case + " " + answer + "\n");
        }
        System.out.println(sb);
    }
    static void dfs(int idx, int sum){
        if (idx >= 12) {
            answer = Math.min(answer, sum);
            return;
        }
        // 만약 현재 가격이 0이면, 그냥 바로 다음으로 진행
        if(price[idx] == 0){
            dfs(idx + 1, sum);
            return;
        }

        dfs(idx + 1, sum + price[idx]);
        dfs(idx + 3, sum + membership[THREE_MONTH]);
    }
}
