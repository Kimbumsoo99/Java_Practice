package baekjoon.math.b6322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                System.out.println(sb);
                return;
            } else {
                if (t > 1) {
                    sb.append("\n");
                }
                sb.append("Triangle #").append(t++).append("\n");
            }
            if (a == -1) {
                if (b >= c) {
                    sb.append("Impossible.\n");
                } else {
                    sb.append(String.format("a = %.3f\n", Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2))));
                }
            } else if (b == -1) {
                if (a >= c) {
                    sb.append("Impossible.\n");
                } else {
                    sb.append(String.format("b = %.3f\n", Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2))));
                }
            } else {
                sb.append(String.format("c = %.3f\n", Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))));
            }
        }
    }
}