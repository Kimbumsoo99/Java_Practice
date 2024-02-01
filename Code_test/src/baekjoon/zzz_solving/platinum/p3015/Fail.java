package baekjoon.zzz_solving.platinum.p3015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fail {

    static int[] arr;
    static int count = 0, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        count = N - 1;
        for (int i = 0; i < N - 2; i++) {
            find(arr[i], i);
        }
        System.out.println(count);
    }
    static void find(int tall, int idx){
        int midTop = arr[idx + 1];
        for (int i = idx + 2; i < N; i++) {
            if (tall >= midTop && arr[i] >= midTop) {
                count++;
                if (arr[i] > midTop) {
                    midTop = arr[i];
                }
            }
        }
    }

}
