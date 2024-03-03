package baekjoon.comb.s6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                System.out.println(sb);
                return;
            }
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0, new int[6]);
            sb.append("\n");
        }
    }

    static void comb(int depth, int idx, int[] lotto) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(lotto[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            lotto[depth] = arr[i];
            comb(depth + 1, i + 1, lotto);
        }
    }
}
