package baekjoon.math.professor_hyunwoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N > 4) {
                int count5 = 0;
                for (int j = 5; j <= N; j *= 5) {
                    count5 += N / j;
                }
                sb.append(count5).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

}
