package baekjoon.implementations.silver.paper_cut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Other {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 행

        int[] width = new int[M + 1];
        int[] height = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 점선 개수
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (mode == 0) { // 가로로
                height[num] = 1; // 행 배열
            } else
                width[num] = 1;
        }
        int temp = 0;
        int maxN = 0;
        for (int i = 1; i <= N; i++) {
            temp++;
            if (height[i] == 1 || i == N) {
                maxN = Math.max(maxN, temp);
                temp = 0;
            }
        }
        temp = 0;
        int maxM = 0;
        for (int i = 1; i <= M; i++) {
            temp++;
            if (width[i] == 1 || i == M) {
                maxM = Math.max(maxM, temp);
                temp = 0;
            }
        }
        System.out.println(maxM * maxN);
    }

}
