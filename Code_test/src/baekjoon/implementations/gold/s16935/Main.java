package baekjoon.implementations.gold.s16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        int R = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int rot = 0; rot < R; rot++) {
            int mode = Integer.parseInt(st.nextToken());

            switch (mode) {
                case 1:
                    topDown();
                    break;
                case 2:
                    leftRight();
                    break;

                case 3:
                    rotateR();
                    break;

                case 4:
                    rotateL();
                    break;
                default:
                    rotateDiv(R, mode);
                    break;
            }
        }
        draw();

    }

    static void draw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(Graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotateDiv(int r, int mode) {
        int[][][] div = new int[4][N / 2][M / 2];
        // 0 => 0, 0 / 1 => N/2,0 / 2 => 0, M/2 / 3 => N/2, M/2
        int sY[] = { N / 2, 0, N / 2, 0 };
        int sX[] = { 0, 0, M / 2, M / 2 };
        if (mode == 6) {
            sY = new int[] { 0, N / 2, 0, N / 2 };
            sX = new int[] { M / 2, M / 2, 0, 0 };
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < (N / 2); j++) {
                for (int k = 0; k < (M / 2); k++) {
                    div[i][j][k] = Graph[j + sY[i]][k + sX[i]];
                }
            }
        }

        int tY[] = { 0, 0, N / 2, N / 2 };
        int tX[] = { 0, M / 2, 0, M / 2 };
        int[][] turnGraph = new int[N][M];
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < M / 2; j++) {
                    turnGraph[i + tY[k]][j + tX[k]] = div[k][i][j];
                }
            }
        }
        Graph = turnGraph;
    }

    static void rotateR() {
        int turnGraph[][] = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                turnGraph[j][N - 1 - i] = Graph[i][j];
            }
        }
        Graph = turnGraph;
        N = Graph.length;
        M = Graph[0].length;
    }

    static void rotateL() {
        int turnGraph[][] = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                turnGraph[M - 1 - j][i] = Graph[i][j];
            }
        }
        Graph = turnGraph;
        N = Graph.length;
        M = Graph[0].length;
    }

    static void leftRight() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = Graph[i][j];
                Graph[i][j] = Graph[i][M - j - 1];
                Graph[i][M - j - 1] = tmp;
            }
        }
    }

    static void topDown() {
        for (int j = 0; j < N / 2; j++) {
            int tmp[] = Graph[j];
            Graph[j] = Graph[N - j - 1];
            Graph[N - j - 1] = tmp;
        }

    }
}
