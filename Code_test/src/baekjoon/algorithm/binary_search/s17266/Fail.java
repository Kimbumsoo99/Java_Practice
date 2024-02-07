package baekjoon.algorithm.binary_search.s17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


// 시간 초과
public class Fail {

    static HashSet<Integer> dark = new HashSet<>();
    static ArrayList<Integer> light = new ArrayList<>();
    static int h = 0, oddMax = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N + 1; i++) {
            dark.add(i);
        }
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int A = Integer.parseInt(st.nextToken());
            dark.remove(A);
            light.add(A);
        }
        for (int i = 1; i < light.size(); i++) {
            if ((light.get(i) - light.get(i - 1)) % 2 == 1) {
                oddMax = Math.max(oddMax, light.get(i) - light.get(i - 1));
            }
        }

        while (!dark.isEmpty()) {
            h++;
            for (Integer idx : light) {
                dark.remove(idx - h);
                dark.remove(idx + h);
            }
        }
        if (M != 1 && oddMax > h * 2) {
            System.out.println(h + 1);
        } else {
            System.out.println(h);
        }
    }
}
