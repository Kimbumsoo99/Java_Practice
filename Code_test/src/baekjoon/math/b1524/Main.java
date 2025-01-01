package baekjoon.math.b1524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int maxA = 0;
            for (int i = 0; i < N; i++) {
                maxA = Math.max(maxA, Integer.parseInt(st.nextToken()));
            }
            int maxB = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                maxB = Math.max(maxB, Integer.parseInt(st.nextToken()));
            }
            sb.append(maxA >= maxB ? "S\n" : "B\n");
        }
        System.out.println(sb);
    }
}