package baekjoon.implementations.gold.g17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, Graph[][];
    static int answer = Integer.MAX_VALUE; // 행에 합 중 최솟값
    static int order[], rot[][];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N + 1][M + 1];
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rot = new int[K][3];
        visit = new boolean[K];
        order = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 시작 r-s, c-s
            int c = Integer.parseInt(st.nextToken()); // 끝 r+s, c+s
            int s = Integer.parseInt(st.nextToken());
            rot[i] = new int[] { r, c, s };
        }
//		rotate(r, c, s);
        getMax(0);
        System.out.println(answer);
    }

    static void getMax(int depth) {
        if (depth == K) {
            int[][] turnGraph = new int[N + 1][M + 1];
            // 맵 복사
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    turnGraph[i][j] = Graph[i][j];
                }
            }

            // 회전 연산
            for (int i = 0; i < depth; i++) {
                rotate(turnGraph, rot[order[i]][0], rot[order[i]][1], rot[order[i]][2]);
            }
//			draw(turnGraph);

            // 최소값 저장
            for (int i = 1; i < N + 1; i++) {
                int sum = Arrays.stream(turnGraph[i]).sum();
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visit[i]) {
                visit[i] = true;
                order[depth] = i;
                getMax(depth + 1);
                visit[i] = false;
            }
        }

    }

    static void draw(int[][] Graph) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(Graph[i + 1][j + 1] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotate(int[][] turnGraph, int y, int x, int s) {
        for (int out = 1; out <= s; out++) {
            int tmp = turnGraph[y - out][x - out];
            for (int i = y - out; i < y + out; i++) { // 왼
                turnGraph[i][x - out] = turnGraph[i + 1][x - out];
            }
            for (int i = x - out; i < x + out; i++) { // 아
                turnGraph[y + out][i] = turnGraph[y + out][i + 1];
            }
            for (int i = y + out; i > y - out; i--) { // 우
                turnGraph[i][x + out] = turnGraph[i - 1][x + out];
            }
            for (int i = x + out; i > x - out; i--) {
                turnGraph[y - out][i] = turnGraph[y - out][i - 1];
            }
            turnGraph[y - out][x - out + 1] = tmp;
        }
    }
}
