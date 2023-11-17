package baekjoon.dp.hide_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] dx = new int[]{-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        dp = new int[100001];
        for (int i = 0; i < 100001; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[start] = 0;
        bfs(start, finish);
        System.out.println(dp[finish]);


    }

    static void bfs(int start, int finish) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start, 0}); // 위치, 시간
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst(); // 3 7
            if (tmp[0] * 2 <= finish + 1) {
                if (tmp[0] * 2 == finish) {
                    dp[finish] = Math.min(dp[finish], tmp[1]);
                } else {
                    if (dp[tmp[0] * 2] > tmp[1]) {
                        dq.offer(new int[]{tmp[0] * 2, tmp[1]});
                        dp[tmp[0] * 2] = tmp[1];
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                int nextX = tmp[0] + dx[i];
                if (nextX == finish) {
                    dp[finish] = Math.min(dp[finish], tmp[1] + 1);
                }
                else if (nextX >= 0 && nextX < 100001) {
                    if (dp[nextX] > tmp[1] + 1) { //
                        dp[nextX] = tmp[1] + 1;
                        dq.offer(new int[]{nextX, tmp[1] + 1});
                    }
                }
            }
        }
    }



}
