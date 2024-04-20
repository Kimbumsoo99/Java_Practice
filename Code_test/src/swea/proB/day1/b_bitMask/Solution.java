package swea.proB.day1.b_bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String answer = "";
            if ((M & ((1 << N) - 1)) == (1 << N) - 1) {
                answer = "ON";
            } else {
                answer = "OFF";
            }
            System.out.printf("#%d %s\n", test_case, answer);
        }
    }

}
