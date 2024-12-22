package baekjoon.math.b2530;

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
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine());

        K += D;
        M += (K / 60);
        K = K % 60;
        N += (M / 60);
        M = M % 60;
        N = N % 24;
        System.out.print(N + " " + M + " " + K);
    }
}
