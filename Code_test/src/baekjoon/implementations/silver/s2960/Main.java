package baekjoon.implementations.silver.s2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 에라토스테네스의 체, 실버IV, 2960번
public class Main {

    public static void main(String[] args) throws IOException {
        int[] num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        num[0] = num[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            num[i] = i;
        }

        int count = 0;
        int answer = 0;
        for (int i = 2; i < N + 1; i++) {
            if (num[i] == 0) {
                continue;
            }
            int P = num[i];
//            System.out.println(num[P]);
            num[P] = 0;
            int m = 2;
            count++;
            if (count == K) {
                answer = P;
            }
            while (P * m < N + 1) {
                if (num[P * m] == 0) {
                    m++;
                    continue;
                }
//                System.out.print(num[P * m] + " \n");
                num[P * m] = 0;
                count++;
                if (count == K) {
                    answer = P * m;
                }
                m++;
            }
        }
        System.out.println(answer);
    }
}
