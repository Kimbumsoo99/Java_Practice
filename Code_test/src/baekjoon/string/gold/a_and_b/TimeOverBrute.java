package baekjoon.string.gold.a_and_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeOverBrute {

    static int aLen = 0;
    static int bLen = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == 'A') {
                aLen++;
            } else {
                bLen++;
            }
        }
        int tmpALen = 0;
        int tmpBLen = 0;
        for (int i = 0; i < S.length(); i++) {
            if (T.charAt(i) == 'A') {
                tmpALen++;
            } else {
                tmpBLen++;
            }
        }
        check(S, S.length(), T, T.length(), tmpALen, tmpBLen);
        System.out.println(0);
    }

    private static void check(String S, int sLen, String T, int tLen, int tmpALen, int tmpBLen) {
        if (sLen == tLen) {
            if (S.equals(T)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }
        if (bLen < tmpBLen || aLen < tmpALen) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(S).reverse();
                check(sb.toString() + "B", sLen + 1, T, tLen, tmpALen, tmpBLen + 1);
            } else {
                check(S + "A", sLen + 1, T, tLen, tmpALen + 1, tmpBLen);
            }
        }
    }

}
