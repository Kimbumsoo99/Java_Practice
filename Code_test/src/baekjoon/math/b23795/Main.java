package baekjoon.math.b23795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) {
                System.out.println(s);
                return;
            }
            s += N;
        }
    }
}
