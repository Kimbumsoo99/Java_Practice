package baekjoon.implementations.silver.mine_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] Graph;
    static int[][] answer;
    static int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new char[N][N];
        answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                Graph[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Graph[i][j] != '.') {
                    for (int k = 0; k < dx.length; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph.length) {
                            if (Graph[nextY][nextX] == '.') {
                                answer[nextY][nextX] += (Graph[i][j] - '0');
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Graph[i][j] != '.') {
                    sb.append('*');
                } else if (answer[i][j] > 9) {
                    sb.append('M');
                } else {
                    sb.append(answer[i][j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static char find(int y, int x) {
        if (Graph[y][x] != '.') {
            return '*';
        }
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph.length) {
                if (Graph[nextY][nextX] != '.') {
                    count += (Graph[nextY][nextX] - '0');
//                    System.out.println(count);
                }
            }
        }

        if (count > 9) {
            return 'M';
        } else {
            return (char) (count + '0');
        }
    }

}
