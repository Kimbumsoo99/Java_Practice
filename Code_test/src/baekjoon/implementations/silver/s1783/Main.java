package baekjoon.implementations.silver.s1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, M));
    }

    private static int solution(int r, int c) {
        if (r == 1) {
            return 1;
        } else if (r == 2) {
            return Math.min(4, (c + 1) / 2);
        } else {
            if (c < 7) {
                return Math.min(4, c);
            } else {
                return c - 2;
            }
        }

    }

}
