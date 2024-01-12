package baekjoon.dp.s2670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class For {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        int N = Integer.parseInt(st.nextToken());
        double dp[] = new double[N + 1];
        double S[] = new double[N + 1];
        for (int i = 1; i < N + 1; i++) {
            S[i] = Double.parseDouble(br.readLine());
            dp[i] = S[i];
        }

        for (int i = 1; i < N + 1; i++) {
            double tmpMax = S[i];
            for (int j = i + 1; j < N + 1; j++) {
                tmpMax *= S[j];
                if (dp[i] < tmpMax) {
                    dp[i] = tmpMax;
                }
            }
            max = max < dp[i] ? dp[i] : max;
        }
        double answer = Math.round((max * 1000)) / 1000.0;
        System.out.printf("%.3f", answer);
    }
}
