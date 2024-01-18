package baekjoon.dp.g2591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] P = str.toCharArray();
        int[] dp = new int[P.length];

        dp[0] = 1;
        if(P.length > 1 && (P[0] - '0') * 10 + (P[1] - '0') < 35 && P[1] != '0') {
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            if((P[i-1] - '0') * 10 + (P[i] - '0') < 35 && P[i] == '0') {
                dp[i] = dp[i-2];
            }else if(P[i-1] == '0') {
                dp[i] = dp[i-1];
            }
            else if((P[i-1] - '0') * 10 + (P[i] - '0') < 35) {
                dp[i] = dp[i-2] + dp[i-1];
            }else {
                dp[i] = dp[i-1];
            }
        }
//		System.out.println(Arrays.toString(dp));


        System.out.println(dp[P.length-1]);
    }
}
