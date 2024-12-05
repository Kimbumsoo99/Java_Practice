package baekjoon.algorithm.binary_search.s7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Double> setA = new ArrayList<>();
            ArrayList<Double> setB = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                setA.add(Double.parseDouble(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                setB.add(Double.parseDouble(st.nextToken()));
            }

            Collections.sort(setA);
            Collections.sort(setB);

            int count = 0;

            for (int i = 0; i < M; i++) {
                double val = setB.get(i) + 0.5;
                int idx = Collections.binarySearch(setA, val);
                if (idx >= 0) {
                    count += setA.size() - idx;
                } else if (idx >= -setA.size()) {
                    count += setA.size() - (-idx - 1);
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
// 양수면 size() - idx
// 음수면 size() - (-idx - 1)