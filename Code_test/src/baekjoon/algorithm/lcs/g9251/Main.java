package baekjoon.algorithm.lcs.g9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String lcs = br.readLine();
        dp = new int[S.length() + 1][lcs.length() + 1];
        for (int i = 1; i <= S.length(); i++) {
            char current = S.charAt(i - 1);
            for (int j = 1; j < lcs.length() + 1; j++) {
                char tmp = lcs.charAt(j - 1);
//                System.out.println(current +" " + tmp);
                if (current == tmp) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]);
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < S.length() + 1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(backTracking(lcs,S,lcs.length()-1,S.length()-1));
        System.out.println(dp[S.length()][lcs.length()]);
    }

    static String backTracking(String a, String b, int i, int j) {
        System.out.println(i+" " +j);
        if (i == 0 || j == 0) {
            return "";
        } else if (a.charAt(i) == b.charAt(j)) {
            return backTracking(a, b, i - 1, j - 1) + a.charAt(i);
        }

        if (dp[i][j - 1] >= dp[i - 1][j]) {
            return backTracking(a, b, i, j - 1);
        } else {
            return backTracking(a, b, i - 1, j);
        }
    }
}
