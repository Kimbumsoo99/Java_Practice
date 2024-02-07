package baekjoon.algorithm.binary_search.s17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int lo = 1;
        int hi = N;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            boolean flag = false;
            int point = 0;

            for (int i = 0; i < M; i++) {
                if (arr[i] - mid <= point) {
                    point = arr[i] + mid;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) { // 여백이 있음
                lo = mid + 1; // 높이가 커져야 함
            } else { // 여백이 없음
                answer = Math.min(answer, mid);
                hi = mid - 1; // 높이가 작아져도 됨
            }
        }

        if (N - arr[M - 1] > answer) {
            answer = N - arr[M - 1];
        }
        System.out.println(answer);
    }

}
