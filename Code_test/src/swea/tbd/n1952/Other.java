package swea.tbd.n1952;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Other {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            System.out.println("테케 : " + tc);
            int[] ticket = new int[4];
            int[] month = new int[13];
            int[] dp = new int[13];
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < 4; i++) ticket[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= 12; i++) month[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= 12; i++) {
                dp[i] = dp[i-1] + month[i] * ticket[0];
                dp[i] = Math.min(dp[i], dp[i-1] + ticket[1]);
                if (i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + ticket[2]);
                if (i == 12) dp[i] = Math.min(dp[i], ticket[3]);
                System.out.println(Arrays.toString(dp));
            }

            sb.append(dp[12]).append("\n");
        }
        System.out.println(sb);
    }
}