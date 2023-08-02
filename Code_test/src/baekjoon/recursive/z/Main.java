package baekjoon.recursive.z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0803 품, 후에 다시 풀이보기
public class Main {
    static int aR;
    static int aC;
    static int N;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        aR = Integer.parseInt(st.nextToken());
        aC = Integer.parseInt(st.nextToken());

        recursive((int) Math.pow(2, N), aR, aC);
        System.out.println(count);
    }

    static void recursive(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        int tmp = size / 2;
//        System.out.println(tmp + " " + r + " " + c);
        if(r < tmp && c < tmp) { // 1사분면
            recursive(tmp, r, c);
        } else if (r < tmp && c >= tmp) { // 2사분면
            count += tmp * tmp;
            recursive(tmp, r, c - tmp);
        } else if (r >= tmp && c < tmp) { // 3사분면
            count += (tmp * tmp) * 2;
            recursive(tmp, r - tmp, c);
        } else { // 4사분면
            count += (tmp * tmp) * 3;
            recursive(tmp, r - tmp, c - tmp);
        }
    }

}
