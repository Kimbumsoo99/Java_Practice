package baekjoon.dp.g2133;
import java.util.Scanner;

public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = 11;
        for (int i = 5; i < N+1; i++) {
            if(i%2==1) dp[i] = 0;
            else {
                for(int j=2;j<=i-2;j+=2) {
                    if(j==2)dp[i] += 3*dp[i-j];
                    else dp[i] += 2*dp[i-j];
                }
                dp[i] += 2;
            }
        }
        System.out.println(dp[N]);
    }
}
