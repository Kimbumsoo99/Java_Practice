package baekjoon.implementations.gold.g1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 초과 해결 실패
public class Fail {
    static int[][] Graph;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int max = Math.max(Math.max(Math.abs(r1), Math.abs(r2)),
            Math.max(Math.abs(c1), Math.abs(c2)));
        int N = max * 2 + 1;
        Graph = new int[N][N];

        int count = 1;
        int y, x;
        y = x = max;
        Graph[y][x] = count++;
        x++;
//        System.out.println(y + " " + x);
        while (count <= N * N) {
            Graph[y][x] = count++;
            if (y > 0 && Graph[y - 1][x] == 0 && Graph[y][x - 1] != 0) {
                y--;
            } else if (x > 0 && Graph[y][x - 1] == 0 && Graph[y + 1][x] != 0) {
                x--;
            } else if (y < N - 1 && Graph[y + 1][x] == 0 && Graph[y][x + 1] != 0) {
                y++;
            } else if (x < N - 1 && Graph[y][x + 1] == 0 && Graph[y - 1][x] != 0) {
                x++;
            }
//            System.out.println(y + " " + x);
        }

        int maxNum = Integer.MIN_VALUE;
        for (int i = r1 + max; i <= r2 + max; i++) {
            for (int j = c1 + max; j <= c2 + max; j++) {
                if (maxNum < Graph[i][j]) {
                    maxNum = Graph[i][j];
                }
            }
        }
        int length = String.valueOf(maxNum).length();
        int lenNum = 10 * (length - 1); // 2자리수면 10

        StringBuilder sb = new StringBuilder();
        for (int i = r1 + max; i <= r2 + max; i++) {
            for (int j = c1 + max; j <= c2 + max; j++) {
                for (int k = Graph[i][j]; k < lenNum; k *= 10) {
                    sb.append(" ");
                }
                sb.append(Graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
