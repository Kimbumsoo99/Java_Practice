package swea.tbd.n4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, Graph[][], answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            Graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] comb = new int[N];
            for (int i = N / 2; i < N; i++) {
                comb[i] = 1;
            }
            int A;
            int B;
            do {
                A = 0;
                B = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (i != j && comb[i] == comb[j]) {
                            if (comb[i] == 1) {
                                A += Graph[i][j];
                            } else {
                                B += Graph[i][j];
                            }
                        }
                    }
                }
                answer = Math.min(answer, Math.abs(A - B));
            } while (np(comb));
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static boolean np(int[] p) {
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i])
            --i;
        if (i == 0)
            return false;

        int j = N - 1;
        while (p[i - 1] >= p[j])
            --j;

        swap(p, i - 1, j);
        int k = N - 1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
