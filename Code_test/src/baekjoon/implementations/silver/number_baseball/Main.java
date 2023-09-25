package baekjoon.implementations.silver.number_baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] numList = new int[N];
        int[] strike = new int[N];
        int[] ball = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numList[i] = Integer.parseInt(st.nextToken());
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 123; i <= 987; i++) {
            String tmp = String.valueOf(i);
            if (tmp.charAt(0) == tmp.charAt(1) || tmp.charAt(1) == tmp.charAt(2)
                || tmp.charAt(0) == tmp.charAt(2)) {
                continue;
            }
            if (tmp.charAt(0) == '0' || tmp.charAt(1) == '0' || tmp.charAt(2) == '0') {
                continue;
            }
            if (canNum(i, numList, strike, ball)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean canNum(int current, int[] numList, int[] strike, int[] ball) {
        for (int i = 0; i < N; i++) {
            String currentStr = String.valueOf(current);
            String numStr = String.valueOf(numList[i]);
            int strikeCount = 0;
            int ballCount = 0;
            for (int j = 0; j < 3; j++) {
                if (currentStr.charAt(j) == numStr.charAt(j)) {
                    strikeCount++;
                }
                for (int k = 0; k < 3; k++) {
                    if (!(j == k)) {
                        if (currentStr.charAt(j) == numStr.charAt(k)) {
                            ballCount++;
                        }
                    }
                }
            }

            if (strikeCount != strike[i] || ballCount != ball[i]) {
                return false;
            }
        }
        return true;
    }
}
