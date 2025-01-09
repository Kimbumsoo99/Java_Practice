package baekjoon.algorithm.binary_search.g14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list;
    static int min = Integer.MAX_VALUE;
    static int ansS, ansE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ansS = 0;
        ansE = N - 1;
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N - 1; i++) {
            binarySearch(i);
        }
        System.out.println(list.get(ansS) + list.get(ansE));
    }

    private static void binarySearch(int s) {
        int start = s + 1;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = list.get(s) + list.get(mid);

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ansS = s;
                ansE = mid;
            }

            if (sum < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}