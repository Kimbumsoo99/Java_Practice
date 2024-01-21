package baekjoon.algorithm.binary_search.s2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int max = 0;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(max < arr[i]) max = arr[i];
        }
        int lo = 1;
        int hi = max;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            long len = 0;
            for (int i = 0; i < N; i++){
                if (mid < arr[i]) {
                    len += arr[i] - mid;
                }
            }
            if (len >= (long) K) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        System.out.println(lo - 1);
    }
}
