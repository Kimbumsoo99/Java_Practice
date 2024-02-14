package baekjoon.backtracking.gold.g6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph, arr;
    static boolean flag, visit[][];
    static final int FIN = (6 * 5) / 2; // 6C2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            Graph = new int[6][3];
            arr = new int[6][3];
            flag = false;
            visit = new boolean[6][6];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    Graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            if (failCheck()) {
                sb.append("0 ");
                continue;
            }
            recur(0, 1, 0);
            if (flag) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    static boolean failCheck() {
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += Graph[i][j];
            }
            if (sum != 5)
                return true;
        }
        return false;
    }

    static void recur(int current, int next, int depth) {
//		System.out.println(current + " " + next);
        if (depth == FIN) {
            flag = true;
            return;
        }
        if (!visit[current][next]) {
            visit[current][next] = true;
            if (Graph[current][0] > arr[current][0] && Graph[next][2] > arr[next][2]) {
                // 이긴 경우
                arr[current][0]++;
                arr[next][2]++;
                if (next + 1 == 6) {
                    recur(current + 1, current + 2, depth + 1);
                } else {
                    recur(current, next + 1, depth + 1);
                }
                arr[current][0]--;
                arr[next][2]--;
            }
            if (Graph[current][1] > arr[current][1] && Graph[next][1] > arr[next][1]) {
                // 비긴 경우
                arr[current][1]++;
                arr[next][1]++;
                if (next + 1 == 6) {
                    recur(current + 1, current + 2, depth + 1);
                } else {
                    recur(current, next + 1, depth + 1);
                }
                arr[current][1]--;
                arr[next][1]--;
            }
            if (Graph[current][2] > arr[current][2] && Graph[next][0] > arr[next][0]) {
                // 진 경우
                arr[current][2]++;
                arr[next][0]++;
                if (next + 1 == 6) {
                    recur(current + 1, current + 2, depth + 1);
                } else {
                    recur(current, next + 1, depth + 1);
                }
                arr[current][2]--;
                arr[next][0]--;
            }
            visit[current][next] = false;
        }
    }
}
