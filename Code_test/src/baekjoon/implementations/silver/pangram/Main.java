package baekjoon.implementations.silver.pangram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            int[] ap = new int[('z' - 'a') + 1];
            String tmp = br.readLine();
            tmp = tmp.toLowerCase();
            for (char c : tmp.toCharArray()) {
                if (c < 'a' || c > 'z') {
                    continue;
                }
                int idx = c - 'a';
                ap[idx]++;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < ap.length; j++) {
                min = Math.min(min, ap[j]);
            }

            String pangram = "";
            if (min == 0) {
                pangram = "Not a pangram";
            } else if (min == 1) {
                pangram = "Pangram!";
            } else if (min == 2) {
                pangram = "Double pangram!!";
            } else {
                pangram = "Triple pangram!!!";
            }

            System.out.println("Case " + i + ": " + pangram);
        }
    }
}
