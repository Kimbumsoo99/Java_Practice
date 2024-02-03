package baekjoon.simulation.g15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, -1, 0, 1 };
    static ArrayList<int[]> list = new ArrayList<>();
    static int zeroCnt = 0;
    static int answer = Integer.MAX_VALUE;
    static int N, M;
    static int directionArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (Graph[i][j] == 0) {
                    zeroCnt++;
                } else if (Graph[i][j] < 6) {
                    list.add(new int[] { Graph[i][j], i, j }); // CCTV 종류, y, x, 방향
                }
            }
        }
        directionArr = new int[list.size()];
        cctvRange(0);
        System.out.println(answer);
    }

    static void cctvRange(int depth) {
        if (depth == list.size()) {
            answer = Math.min(answer, zeroCnt - getCount());
            return;
        }

        int[] cctv = list.get(depth);
        for (int i = 0; i < 4; i++) {
            if (cctv[0] == 2 && i == 2) {
                break;
            }
            directionArr[depth] = i;
            cctvRange(depth + 1);
            if (cctv[0] == 5) {
                break;
            }
        }
    }

    static int getCount() {
        int zero = 0;
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < list.size(); i++) {
            int[] cctv = list.get(i);
            zero += mapping(cctv, visit, directionArr[i]);
        }
        return zero;
    }

    static int mapping(int[] cctv, boolean[][] visit, int dir) {
        int zero = 0;
        int sY = cctv[1];
        int sX = cctv[2];
        switch (cctv[0]) {
            case 1:
                zero += forward(sY, sX, 0, dir, visit);
                break;
            case 2:
                zero += forward(sY, sX, 0, dir, visit);
//			System.out.println(zero + " 2번에 왼쪽 확인 하고 나옴");
                zero += forward(sY, sX, 0, dir + 2, visit); // 어처피 0이랑 1만 옴
//			System.out.println(zero + " 2번에 오른쪽 확인 하고 나옴");
                break;
            case 3:
                zero += forward(sY, sX, 0, dir, visit);
                zero += forward(sY, sX, 0, (dir + 1) % 4, visit);
                break;
            case 4:
                zero += forward(sY, sX, 0, dir, visit);
                zero += forward(sY, sX, 0, (dir + 1) % 4, visit);
                zero += forward(sY, sX, 0, (dir + 2) % 4, visit);
                break;
            default:
                for (int i = 0; i < 4; i++) {
                    zero += forward(sY, sX, 0, i, visit);
                }
                break;
        }
        return zero;
    }

    static int forward(int y, int x, int zero, int direction, boolean[][] visit) {
        while (isMap(y, x)) {
//			System.out.println(y + " " + x);
            if (!visit[y][x] && Graph[y][x] == 0) {
                visit[y][x] = true;
                zero += 1;
            } else if (Graph[y][x] == 6) {
                break;
            }
            y += dy[direction];
            x += dx[direction];
        }
        return zero;

    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }
}
