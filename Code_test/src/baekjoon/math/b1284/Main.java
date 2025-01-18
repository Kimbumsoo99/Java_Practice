package baekjoon.math.b1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = new int[10];
        tmp[0] = 4;
        tmp[1] = 2;
        for (int i = 2; i < 10; i++) {
            tmp[i] = 3;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            int answer = 1;
            while (num > 0) {
                int mod = num % 10;
                answer += tmp[mod] + 1;
                num /= 10;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}