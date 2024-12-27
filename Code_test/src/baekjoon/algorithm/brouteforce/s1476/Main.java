package baekjoon.algorithm.brouteforce.s1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 0;
        int s = 0;
        int m = 0;
        int year = 0;
        while (true) {
            year++;
            e = e % 15 + 1;
            s = s % 28 + 1;
            m = m % 19 + 1;
            if (E == e && M == m && s == S) {
                break;
            }
        }
        System.out.print(year);
    }
}