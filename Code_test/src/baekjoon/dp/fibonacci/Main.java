package baekjoon.dp.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // null 체크를 하기 위해 int[][] 배열이 아닌 Integer[][] 배열
    // int[][] 배열을 쓰고자 한다면 모든 배열의 값을 -1 과 같은 값으로 모두 초기화
    static Integer[][] dp = new Integer[41][2];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Integer tmp[] = fibonacci(N);
            sb.append(tmp[0]).append(" ").append(tmp[1]).append("\n");
        }
        System.out.println(sb);
    }

    static Integer[] fibonacci(int N) {
        if (dp[N][0] == null || dp[N][1] == null) {
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        return dp[N];
    }

}
