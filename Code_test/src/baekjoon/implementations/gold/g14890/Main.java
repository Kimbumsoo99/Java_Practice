package baekjoon.implementations.gold.g14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, X, Graph[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        StringTokenizer st = null;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                if (check(Graph[i]))
                    answer++;
            }
            for (int i = 0; i < N; i++) {
                int[] arr = new int[N];
                for (int j = 0; j < N; j++) {
                    arr[j] = Graph[j][i];
                }
                if (check(arr)) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    static boolean check(int[] arr) {
        int pre = arr[0], cur = arr[0], count = 1;
        for (int i = 1; i < N; i++) {
            cur = arr[i];
            if (cur == pre)
                count++;
            else if (Math.abs(cur - pre) > 1) {
                return false;
            } else if (cur > pre) {
                if (count >= X) {
                    count = 1;
                } else {
                    return false;
                }
            } else if (cur < pre) {
                for (int j = 1; j < X; j++) {
                    if (i + j < N) {
                        if (arr[i] != arr[i + j]) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                i += (X - 1);
                count = 0;
            } else {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}