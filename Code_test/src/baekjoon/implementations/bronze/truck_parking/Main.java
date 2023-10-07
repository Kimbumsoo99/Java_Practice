package baekjoon.implementations.bronze.truck_parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] park = new int[]{A, B, C};
        boolean[][] visit = new boolean[3][101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            for (int j = in; j < out; j++) {
                visit[i][j] = true;
            }
        }
        int answer = 0;
        for (int i = 1; i < 101; i++) {
            int count = -1;
            for (int j = 0; j < 3; j++) {
                if (visit[j][i]) {
                    count++;
                }
            }
            if (count != -1) {
                answer += (count + 1) * park[count];
//                System.out.println(i + " " + answer);
            }
        }
        System.out.println(answer);
    }
}
