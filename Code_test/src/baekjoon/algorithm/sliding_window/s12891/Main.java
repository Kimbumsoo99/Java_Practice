package baekjoon.algorithm.sliding_window.s12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// DNA 비밀번호, 실버 2
// 슬라이딩 윈도우 예제, 두잇 책
public class Main {

    static int[] dnaNum = new int[4];
    static char[] dna = new char[]{'A', 'C', 'G', 'T'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String S = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dnaNum[i] = Integer.parseInt(st.nextToken());
        }

        int length = N - K;

        int[] correct = new int[5]; // A, C, G, T, 외
        for (int i = 0; i < K; i++) {
            correct[findDNA(S.charAt(i))]++;
        }

        int start = 0;
        int end = K - 1;
        int count = 0;
        while (end < N) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (dnaNum[i] > correct[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
            if (end == N - 1) {
                break;
            }

            correct[findDNA(S.charAt(start))]--;
            start++;
            end++;
            correct[findDNA(S.charAt(end))]++;
        }
        System.out.println(count);
    }

    static int findDNA(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else if (c == 'T') {
            return 3;
        } else {
            return 4;
        }
    }
}
