package baekjoon.graph.all.g13460.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 구슬 탈출2
 * 왼오위아 기울이기를 통해 공 움직이기.
 * 최대 10번
 * 빨간 구슬만 구멍에 들어가야 성공, 파란것이 들어가면 실패
 *
 * 빨간구슬(R) -> 2
 * 파란구슬(B) -> 3
 * 구멍(O) -> 4
 * 벽(#) -> 1
 */

public class Main {
    static int N, M, initMap[][], answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        initMap = new int[N][M];
        int[] R = new int[2];
        int[] B = new int[2];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[j] == '#') {
                    initMap[i][j] = 1;
                } else if (arr[j] == 'R') {
                    initMap[i][j] = 2;
                    R = new int[] { i, j };
                } else if (arr[j] == 'B') {
                    initMap[i][j] = 3;
                    B = new int[] { i, j };
                } else if (arr[j] == 'O') {
                    initMap[i][j] = 4;
                }
            }
        }

        // 왼, 우, 위, 아 순서대로 넣어서 돌리기.
        left(1, copy(initMap), R, B);
        right(1, copy(initMap), R, B);
        up(1, copy(initMap), R, B);
        down(1, copy(initMap), R, B);

        System.out.println(answer);
    }

    static int[][] copy(int map[][]) {
        int[][] Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            Graph[i] = map[i].clone();
        }
        return Graph;
    }

    // 내려가는 경우의 수(R)
    // 1. R이 벽에 닿는 경우
    // 1-1. B도 벽에 닿을 때까지 이동하기
    // 2. R이 구멍에 닿는 경우
    // 2-1. B도 구멍에 닿는지 확인하기(아니라면 게임 끝)
    // 3. R이 B에 닿는 경우 ***
    // 3-1. B를 먼저 이동시킨 뒤, R을 이동시키기

    static void left(int depth, int[][] Graph, int[] R, int[] B) {
        if ((answer != -1 && answer <= depth) || depth > 10) {
            return;
        }

        boolean redFlag = false;
        boolean reFlag = false;

        int nY = R[0];
        int nX = R[1] - 1;
        Graph[R[0]][R[1]] = 0; // 빨간 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nX--;
        }
        if (Graph[nY][nX] == 1) {
            Graph[nY][nX + 1] = 2; // 빨간 구슬 이동
        } else if (Graph[nY][nX] == 4) {
            redFlag = true; // 빨간 구슬 골인
        } else if (Graph[nY][nX] == 3) { // 파란 구슬에 닿으면, 파란 구슬 이동 후 다시 이동
            reFlag = true;
        }

        int[] newR = new int[] { nY, nX + 1 };

        nY = B[0];
        nX = B[1] - 1;
        Graph[B[0]][B[1]] = 0; // 파란 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nX--;
        }

        if (Graph[nY][nX] == 1 || Graph[nY][nX] == 2) {
            Graph[nY][nX + 1] = 3; // 파란 구슬 이동
        } else if (Graph[nY][nX] == 4) { // 파란 구슬 골인시에는 망한 케이스
            return;
        }

        int[] newB = new int[] { nY, nX + 1 };

        if (reFlag) { // 파 -> 빨 순서로 이동하는 경우
            nY = newR[0];
            nX = newR[1] - 1;
            while (Graph[nY][nX] != 3) {
                nX--;
            }
            Graph[nY][nX + 1] = 2;
            newR[0] = nY;
            newR[1] = nX + 1;
        }

        if (redFlag) {
            answer = depth;
            return;
        }

        right(depth + 1, copy(Graph), newR, newB);
        down(depth + 1, copy(Graph), newR, newB);
        up(depth + 1, copy(Graph), newR, newB);
    }

    static void right(int depth, int[][] Graph, int[] R, int[] B) {
        if ((answer != -1 && answer <= depth) || depth > 10) {
            return;
        }

        boolean redFlag = false;
        boolean reFlag = false;

        int nY = R[0];
        int nX = R[1] + 1;
        Graph[R[0]][R[1]] = 0; // 빨간 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nX++;
        }
        if (Graph[nY][nX] == 1) {
            Graph[nY][nX - 1] = 2; // 빨간 구슬 이동
        } else if (Graph[nY][nX] == 4) {
            redFlag = true; // 빨간 구슬 골인
        } else if (Graph[nY][nX] == 3) { // 파란 구슬에 닿으면, 파란 구슬 이동 후 다시 이동
            reFlag = true;
        }

        int[] newR = new int[] { nY, nX - 1 };

        nY = B[0];
        nX = B[1] + 1;
        Graph[B[0]][B[1]] = 0; // 파란 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nX++;
        }

        if (Graph[nY][nX] == 1 || Graph[nY][nX] == 2) {
            Graph[nY][nX - 1] = 3; // 파란 구슬 이동
        } else if (Graph[nY][nX] == 4) { // 파란 구슬 골인시에는 망한 케이스
            return;
        }

        int[] newB = new int[] { nY, nX - 1 };

        if (reFlag) { // 파 -> 빨 순서로 이동하는 경우
            nY = newR[0];
            nX = newR[1] + 1;
            while (Graph[nY][nX] != 3) {
                nX++;
            }
            Graph[nY][nX - 1] = 2;
            newR[0] = nY;
            newR[1] = nX - 1;
        }

        if (redFlag) {
            answer = depth;
            return;
        }

        left(depth + 1, copy(Graph), newR, newB);
        down(depth + 1, copy(Graph), newR, newB);
        up(depth + 1, copy(Graph), newR, newB);
    }

    static void up(int depth, int[][] Graph, int[] R, int[] B) {
        if ((answer != -1 && answer <= depth) || depth > 10) {
            return;
        }

        boolean redFlag = false;
        boolean reFlag = false;

        int nY = R[0] - 1;
        int nX = R[1];
        Graph[R[0]][R[1]] = 0; // 빨간 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nY--;
        }
        if (Graph[nY][nX] == 1) {
            Graph[nY + 1][nX] = 2; // 빨간 구슬 이동
        } else if (Graph[nY][nX] == 4) {
            redFlag = true; // 빨간 구슬 골인
        } else if (Graph[nY][nX] == 3) { // 파란 구슬에 닿으면, 파란 구슬 이동 후 다시 이동
            reFlag = true;
        }

        int[] newR = new int[] { nY + 1, nX };

        nY = B[0] - 1;
        nX = B[1];
        Graph[B[0]][B[1]] = 0; // 파란 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nY--;
        }

        if (Graph[nY][nX] == 1 || Graph[nY][nX] == 2) {
            Graph[nY + 1][nX] = 3; // 파란 구슬 이동
        } else if (Graph[nY][nX] == 4) { // 파란 구슬 골인시에는 망한 케이스
            return;
        }

        int[] newB = new int[] { nY + 1, nX };

        if (reFlag) { // 파 -> 빨 순서로 이동하는 경우
            nY = newR[0] - 1;
            nX = newR[1];
            while (Graph[nY][nX] != 3) {
                nY--;
            }
            Graph[nY + 1][nX] = 2;
            newR[0] = nY + 1;
            newR[1] = nX;
        }

        if (redFlag) {
            answer = depth;
            return;
        }

        left(depth + 1, copy(Graph), newR, newB);
        down(depth + 1, copy(Graph), newR, newB);
        right(depth + 1, copy(Graph), newR, newB);
    }

    static void down(int depth, int[][] Graph, int[] R, int[] B) {
        if ((answer != -1 && answer <= depth) || depth > 10) {
            return;
        }
        boolean redFlag = false;
        boolean reFlag = false;

        int nY = R[0] + 1;
        int nX = R[1];
        Graph[R[0]][R[1]] = 0; // 빨간 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nY++;
        }
        if (Graph[nY][nX] == 1) {
            Graph[nY - 1][nX] = 2; // 빨간 구슬 이동
        } else if (Graph[nY][nX] == 4) {
            redFlag = true; // 빨간 구슬 골인
        } else if (Graph[nY][nX] == 3) { // 파란 구슬에 닿으면, 파란 구슬 이동 후 다시 이동
            reFlag = true;
        }

        int[] newR = new int[] { nY - 1, nX };

        nY = B[0] + 1;
        nX = B[1];
        Graph[B[0]][B[1]] = 0; // 파란 구슬 빈자리
        while (Graph[nY][nX] == 0) {
            nY++;
        }

        if (Graph[nY][nX] == 1 || Graph[nY][nX] == 2) {
            Graph[nY - 1][nX] = 3; // 파란 구슬 이동
        } else if (Graph[nY][nX] == 4) { // 파란 구슬 골인시에는 망한 케이스
            return;
        }

        int[] newB = new int[] { nY - 1, nX };

        if (reFlag) { // 파 -> 빨 순서로 이동하는 경우
            nY = newR[0] + 1;
            nX = newR[1];
            while (Graph[nY][nX] != 3) {
                nY++;
            }
            Graph[nY - 1][nX] = 2;
            newR[0] = nY - 1;
            newR[1] = nX;
        }

        if (redFlag) {
            answer = depth;
            return;
        }

        left(depth + 1, copy(Graph), newR, newB);
        up(depth + 1, copy(Graph), newR, newB);
        right(depth + 1, copy(Graph), newR, newB);
    }
}
