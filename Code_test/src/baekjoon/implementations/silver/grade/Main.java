package baekjoon.implementations.silver.grade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append("Class ").append(i).append("\n");
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                int score = Integer.parseInt(st.nextToken());
                list.add(score);
            }
            Collections.sort(list);
            int largeGap = 0;
            for (int j = 1; j < K; j++) {
                largeGap = Math.max(largeGap, (list.get(j) - list.get(j - 1)));
            }
            // Max 78, Min 23, Largest gap 46
            sb.append("Max ").append(list.get(K - 1)).append(", Min ").append(list.get(0))
                .append(", Largest gap ").append(largeGap).append("\n");
            list.clear();
        }
        System.out.println(sb);
    }

}