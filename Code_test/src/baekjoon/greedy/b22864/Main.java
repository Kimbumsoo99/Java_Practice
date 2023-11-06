package baekjoon.greedy.b22864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 한 시간 일하는 피로도 양
        int B = Integer.parseInt(st.nextToken()); // 일 처리량
        int C = Integer.parseInt(st.nextToken()); // 한 시간 회복되는 피로도 양
        int M = Integer.parseInt(st.nextToken()); // 총 피로도

        int answer = 0;

        int fatigue = 0; // 현재 피로도
        for (int i = 0; i < 24; i++) {
            if (fatigue + A <= M) {
                answer += B;
                fatigue += A;
            } else {
                fatigue -= C;
                if (fatigue < 0) {
                    fatigue = 0;
                }
            }
        }
        System.out.println(answer);
    }

}
