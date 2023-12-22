package baekjoon.implementations.silver.s15719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long answer = 0;
        long sum = 0;
        for (int i = 1; i < N + 1; i++) {
            sum += i;
            int tmp = Integer.parseInt(st.nextToken());
            answer += tmp;
        }
        answer = -(sum - N - answer);
        System.out.println(answer);
    }

}
