package swea.proB.day1.f_practice6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 과제는 아니지만, 비트마스킹 문제라서 해당 패키지에 남김
// 3316. 동아리실 관리하기
public class Solution {
    static long answer = 0L;
    static final int CLUB_MEMBER = 16, MOD = 1_000_000_007;
    static int[][] dp = new int[10001][16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] manager = br.readLine().toCharArray();
            init(manager[0]);


            for (int i = 1; i < manager.length; i++) {
                int cur = (1 << (manager[i] - 'A'));
                // 이전 부원에 대한 경우
                for (int j = 1; j < CLUB_MEMBER; j++) {
                    for (int k = 1; k < CLUB_MEMBER; k++) {
                        // 이전 부원이 포함돼있고, 현재 부원도 포함돼 있는 경우
                        if ((j & k) != 0 && (j & cur) != 0) {
                            dp[i][j] += dp[i - 1][k];
                            dp[i][j] %= MOD;
                        }
                    }
                }
            }
            for (int i = 1; i < CLUB_MEMBER; i++) {
                answer += dp[manager.length - 1][i];
                answer %= MOD;
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void init(char c){
        answer = 0L;
        for (int i = 0; i < 10001; i++) {
            Arrays.fill(dp[i], 0);
        }
        int flag = (1 << (c - 'A'));
        for (int i = 1; i < CLUB_MEMBER; i++) {
            if ((i & flag) != 0 && (i & 1) != 0) {
                dp[0][i] = 1;
            }
        }
    }

}
