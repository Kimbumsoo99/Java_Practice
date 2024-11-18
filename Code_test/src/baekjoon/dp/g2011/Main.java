package baekjoon.dp.g2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] tmp = br.readLine().toCharArray();

        int[] words = new int[5001];

        for (int i = 0; i < tmp.length; i++) {
            words[i] = tmp[i] - '0';
        }

        long[] dp = new long[5001];

        if (words[0] == 0) {
            exit();
        }

        dp[0] = 1;
        for (int i = 1; i < tmp.length; i++) {
            if (words[i] > 0) {
                dp[i] += dp[i - 1];
            }
            int tt = words[i - 1] * 10 + words[i];
            if (tt > 9 && tt < 27) {
                if (i > 1) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] += 1;
                }
            }
            dp[i] %= 1_000_000;
        }
        System.out.println(dp[tmp.length - 1]);
    }

    public static void exit(){
        System.out.println(0);
        System.exit(0);
    }
}
