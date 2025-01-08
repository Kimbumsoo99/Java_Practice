package baekjoon.algorithm.two_pointer.g2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int sp = 0;
        int ep = N - 1;
        int min = Integer.MAX_VALUE;
        int ansS = sp;
        int ansE = ep;

        while (true) {
            if (sp == ep) {
                sb.append(list.get(ansS)).append(' ').append(list.get(ansE));
                break;
            }
            int s = list.get(sp);
            int e = list.get(ep);
            if (Math.abs(min) > Math.abs(s + e)) {
                min = s + e;
                ansS = sp;
                ansE = ep;
            }

            if (s + e < 0) {
                sp++;
            } else if (s + e > 0) {
                ep--;
            } else {
                sb.append(list.get(sp)).append(' ').append(list.get(ep));
                break;
            }
        }
        System.out.println(sb);
    }
}