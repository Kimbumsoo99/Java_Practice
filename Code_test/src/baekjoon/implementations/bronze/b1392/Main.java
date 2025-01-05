package baekjoon.implementations.bronze.b1392;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int s = Integer.parseInt(br.readLine());
            for (int j = 0; j < s; j++) {
                list.add(i);
            }
        }
        for (int i = 0; i < Q; i++) {
            int s = Integer.parseInt(br.readLine());
            sb.append(list.get(s)).append('\n');
        }
        System.out.println(sb);
    }
}