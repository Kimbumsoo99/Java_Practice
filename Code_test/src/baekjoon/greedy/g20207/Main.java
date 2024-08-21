package baekjoon.greedy.g20207;

import java.io.*;
import java.util.*;
public class Main {
    public static int planNum;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        planNum = Integer.parseInt(br.readLine());

        // 일정의 날짜 범위 1 - 365, e+1 구현위해 366까지 idx 존재해야 함.
        int[] dp = new int[367];

        for (int x = 0; x < planNum; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dp[Integer.parseInt(st.nextToken())]++;
            dp[Integer.parseInt(st.nextToken()) + 1]--;
        }

        int prevDay = 0;
        int maxPlan = 0;
        int sum = 0;
        int answer = 0;

        for (int x = 0; x <= 366; x++) {
            sum += dp[x];

            // 최대 일정 개수
            maxPlan = Math.max(maxPlan, sum);


            // 연속되는 일정이 처음 시작될 때 -> prevDay에 현재 날짜 저장
            if (prevDay == 0 && sum != 0) {
                prevDay = x;
            } else if (prevDay != 0 && sum == 0) {
                // 연속되는 일정이 끝날때
                // 연속되는 구간 길이 * 최대 일정의 개수
                answer += (x - prevDay) * maxPlan;
                // 초기화
                prevDay = 0;
                maxPlan = 0;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();

    }
}
