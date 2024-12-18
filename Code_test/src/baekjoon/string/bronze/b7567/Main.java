package baekjoon.string.bronze.b7567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int answer = 10;
        char pre = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (pre != arr[i]) {
                answer += 10;
                pre = arr[i];
            } else {
                answer += 5;
            }
        }
        System.out.println(answer);
    }
}
