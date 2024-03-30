package baekjoon.algorithm.kmp.p1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();
        int[] pi = new int[P.length];
        for (int i = 1, j = 0; i < P.length; i++) {
            while (j > 0 && P[i] != P[j]) {
                j = pi[j - 1];
            }
            if (P[i] == P[j]) {
                pi[i] = ++j;
            } else
                pi[i] = 0;
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < T.length; i++) {
            while (j > 0 && T[i] != P[j]) {
                j = pi[j - 1];
            }

            if (T[i] == P[j]) {
                if (j == P.length - 1) {
                    cnt++;
                    sb.append(i - j + 1).append(" ");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
