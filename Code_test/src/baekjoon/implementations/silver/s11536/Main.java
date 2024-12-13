package baekjoon.implementations.silver.s11536;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str;
        }
        boolean upFlag = arr[0].compareTo(arr[1]) < 0;
        String tmp = upFlag ? "INCREASING" : "DECREASING";
        for (int i = 2; i < N; i++) {
            if (!(upFlag == arr[i - 1].compareTo(arr[i]) < 0)) {
                tmp = "NEITHER";
            }
        }
        System.out.println(tmp);
    }
}
