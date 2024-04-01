package swea.d3.n5607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 페르마 소 정리
public class Solution {
    static long[] fac;
    static long answer = 0;
    static final int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            answer = 0L;
            fac = new long[N + 1];
            if (R == 0) {
                answer = 1;
            } else {
                fac[0] = 1;
                for (int i = 1; i < N + 1; i++) {
                    fac[i] = fac[i - 1] * i % MOD; // 팩토리얼 배열 채우기
                }
                answer = (fac[N] * power(fac[R], MOD - 2) % MOD * power(fac[N - R], MOD - 2) % MOD) % MOD;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static long power(long x, long y) {
        long res = 1L;
        x = x % MOD;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % MOD;
            }
            y = y >> 1;
            x = (x * x) % MOD;
        }

        return res;
    }
}

