package baekjoon.implementations.silver.s1817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 책 갯수
        int M = Integer.parseInt(st.nextToken()); // 박스 무게
        if (N == 0) {
            System.out.println(0);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int answer = 1;
        int box = M;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (box - tmp < 0) {
                answer++;
                box = M;
            }
            box -= tmp;
        }
        System.out.println(answer);

    }

}
