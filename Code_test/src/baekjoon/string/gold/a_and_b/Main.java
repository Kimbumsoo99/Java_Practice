package baekjoon.string.gold.a_and_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        check(S, S.length(), T, T.length());
        System.out.println(0);
    }

    private static void check(String S, int sLen, String T, int tLen) {
        if (sLen == tLen) {
            if (S.equals(T)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        if (T.charAt(tLen - 1) == 'A') {
            check(S, sLen, T.substring(0, tLen - 1), tLen - 1);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(T.substring(0, tLen - 1)).reverse();
            check(S, sLen, sb.toString(), tLen - 1);
        }
    }
}
