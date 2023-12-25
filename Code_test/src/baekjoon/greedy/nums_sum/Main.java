package baekjoon.greedy.nums_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int num = 1;
        long sum = 0;
        int count = 0;
        while (true) {
            if (sum + num <= N) {
                sum += num;
                num++;
            } else {
                break;
            }
            count++;
        }
        System.out.println(count);
    }

}
