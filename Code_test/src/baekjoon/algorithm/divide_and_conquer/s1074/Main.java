package baekjoon.algorithm.divide_and_conquer.s1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int bin = (int) Math.pow(2, N);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        zIndex(0, 0, bin, 0);
        System.out.println(count);
    }

    static void zIndex(int sR, int sC, int bin, int cntt) {
        if (sR == r && sC == c) {
            count = cntt;
            return;
        }
        int bR = sR + bin / 2;
        int bC = sC + bin / 2;
        int cnt = (bin * bin) / 4;
        if (r < bR && c < bC) {
            // 1사 분면
            zIndex(sR, sC, bin / 2, cntt);
        } else if (r < bR && c >= bC) {
            // 2사 분면
            zIndex(sR, bC, bin / 2, cntt + cnt);
        } else if (r >= bR && c < bC) {
            // 3사 분면
            zIndex(bR, sC, bin / 2, cntt + cnt * 2);
        } else {
            // 4사 분면
            zIndex(bR, bC, bin / 2, cntt + cnt * 3);
        }
    }
}
