package baekjoon.algorithm.bit_masking.s1052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, M));
    }

    static int solution(int N, int M){
        /**
         * 1. K-1번 돌면서 남은 물병 보다 작은 2의 base 제곱 값 빼주기 (최대한 많은 물병을 이용해 하나로 만들기)
         * 2. 마지막은 해당 수보다 큰 2의 base 제곱 값 구해서 남은 물병 빼주기
         */
        if (N <= M) {
            return 0;
        }

        int binLen = Integer.toBinaryString(N).length() - 1;
        // 10110101 일때,
        // 10000000 == (1 << binLen)
        // 1. K-1번 돌면서 남은 물병 보다 작은 2의 base 제곱 값 빼주기 (최대한 많은 물병을 이용해 하나로 만들기)
        int i = 0;
        while (i < M - 1) {
            if ((N & (1 << binLen)) != 0) {
                N -= (1 << binLen);
                i++;
            }
            binLen--;
            if (N == 0) {
                return 0;
            }
        }

        binLen = Integer.toBinaryString(N).length();
        if ((1 << binLen - 1) == N) {
            return 0;
        }

        int answer = (1 << binLen) - N;
        return answer;
    }
}
