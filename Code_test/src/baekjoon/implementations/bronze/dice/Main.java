package baekjoon.implementations.bronze.dice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                sb.append("Case ").append(i + 1).append(": ");
                sb.append(A + B).append("\n");
            }
            System.out.println(sb);
        }

}
