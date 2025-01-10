package baekjoon.algorithm.binary_search.g2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Long> list;
    static long min = Long.MAX_VALUE;
    static int ansA, ansB, ansC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ansA = 0;
        ansB = 1;
        ansC = 2;
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                binarySearch(i, j);
            }
        }
        System.out.println(list.get(ansA) + " " + list.get(ansB) + " " + list.get(ansC));
    }

    private static void binarySearch(int a, int s) {
        int start = s + 1;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = list.get(a) + list.get(s) + list.get(mid);

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ansA = a;
                ansB = s;
                ansC = mid;
            }

            if (sum < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}