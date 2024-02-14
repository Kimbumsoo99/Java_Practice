package baekjoon.algorithm.divide_and_conquer.s1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, Graph[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                Graph[i][j] = tmp[j] - '0';
            }
        }
        int tmp = Graph[0][0];
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tmp != Graph[i][j]) {
                    flag = false;
                    sb.append("(");
                    sb.append(recur(0, 0, N));
                    sb.append(recur(0, N / 2, N));
                    sb.append(recur(N / 2, 0, N));
                    sb.append(recur(N / 2, N / 2, N));
                    sb.append(")");
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (flag)
            sb.append(tmp);
        System.out.println(sb);
    }

    static String recur(int y, int x, int bin) {
        if (bin == 2)
            return String.valueOf(Graph[y][x]);
        int tmp = Graph[y][x];
        boolean flag = true;
        int half = bin / 2;
        StringBuilder tmpBuilder = new StringBuilder();

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                if (tmp != Graph[i + y][j + x]) {
                    flag = false;
                    tmpBuilder.append("(");
                    tmpBuilder.append(recur(y, x, half));
                    tmpBuilder.append(recur(y, x + half / 2, half));
                    tmpBuilder.append(recur(y + half / 2, x, half));
                    tmpBuilder.append(recur(y + half / 2, x + half / 2, half));
                    tmpBuilder.append(")");
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (flag) {
            return String.valueOf(tmp);
        }
        return tmpBuilder.toString();
    }
}
