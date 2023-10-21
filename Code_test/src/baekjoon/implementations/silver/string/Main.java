package baekjoon.implementations.silver.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int maxCount = 0;
        for (int i = 0; i < B.length(); i++) {
            int count = 0;
            for (int j = 0; j < A.length(); j++) {
                if (B.length() <= i + j) {
                    count = 0;
                    break;
                }
                if (A.charAt(j) == B.charAt(i + j)) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(A.length() - maxCount);
    }
}
