package baekjoon.string.silver.s17269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int[] count = new int[]{3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        boolean aLongFlag = N > M;
        String lenLong = aLongFlag ? A : B;
        int min = Math.min(N, M);

        int len = N + M;
        int[] arr = new int[len];

        for (int i = 0, j = 0; i < len; i++) {
            if (j >= min) {
                arr[i] = count[lenLong.charAt(j++) - 'A'];
            } else if (i % 2 == 0) {
                arr[i] = count[A.charAt(j) - 'A'];
            } else {
                arr[i] = count[B.charAt(j++) - 'A'];
            }
        }

        while (len-- > 2) {
            for (int i = 1; i < len + 1; i++) {
                arr[i - 1] = (arr[i - 1] + arr[i]) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(arr[0] > 0) sb.append(arr[0]);
        sb.append(arr[1]).append("%");
        System.out.println(sb);
    }
}