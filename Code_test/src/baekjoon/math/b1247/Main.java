package baekjoon.math.b1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger tmp = BigInteger.ZERO;
            for (int j = 0; j < N; j++) {
                tmp = tmp.add(new BigInteger(br.readLine()));
            }

            if(tmp.equals(BigInteger.ZERO)) {
                sb.append("0\n");
            } else if (tmp.equals(tmp.abs())) {
                sb.append("+\n");
            } else {
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}