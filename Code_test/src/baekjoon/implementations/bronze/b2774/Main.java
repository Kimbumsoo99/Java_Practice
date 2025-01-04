package baekjoon.implementations.bronze.b2774;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[11];
            int count = 0;
            while (N > 0) {
                int tmp = N % 10;
                count = !visited[tmp] ? count + 1 : count;
                visited[tmp] = true;
                N /= 10;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}