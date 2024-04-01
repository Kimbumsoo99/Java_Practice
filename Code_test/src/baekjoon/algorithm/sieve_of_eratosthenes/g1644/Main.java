package baekjoon.algorithm.sieve_of_eratosthenes.g1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int sum[];
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list.add(2);
        list.add(3);

        for (int i = 4; i <= N; i++) {
            int tmp = (int) Math.sqrt(i);
            boolean flag = true;
            for (int j = 2; j < tmp + 1; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        sum = new int[list.size() + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + list.get(i - 1);
        }

        int start = 0;
        int end = 1;
        int answer = 0;
        while (start < end && end < sum.length) {
            int a = sum[end] - sum[start];
            if (sum[end] - sum[start] > N) {
                start++;
            } else if (sum[end] - sum[start] == N) {
                answer++;
                end++;
            } else {
                end++;
            }
        }
        System.out.println(answer);
    }

}
