package baekjoon.algorithm.lcs.g9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    static int[] dx = {-1, 0}, dy = {0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = br.readLine();
        String s = br.readLine();
        char[] T = null;
        char[] P = null;
        if (l.length() > s.length()) {
            T = l.toCharArray();
            P = s.toCharArray();
        } else {
            T = s.toCharArray();
            P = l.toCharArray();
        }
        dp = new int[P.length + 1][T.length + 1];

        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < T.length; j++) {
                if(P[i] == T[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int current = dp[P.length][T.length];
        StringBuilder sb = new StringBuilder();
        int cY = P.length;
        int cX = T.length;
//        System.out.println(cY + " " + cX);
        while (current > 0){
            boolean flag = false;
            for (int i = 0; i < 2; i++) {
                int nY = cY + dy[i];
                int nX = cX + dx[i];
                if (dp[nY][nX] == current) {
                    cY = nY;
                    cX = nX;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append(T[cX - 1]);
                cY -= 1;
                cX -= 1;
//                System.out.println(cY + " " + cX);
                current = dp[cY][cX];
            }
        }
        sb.reverse();
        System.out.println(sb.toString().length());
        System.out.println(sb.toString());
    }
}
