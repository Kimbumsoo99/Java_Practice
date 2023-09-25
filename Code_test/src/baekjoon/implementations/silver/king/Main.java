package baekjoon.implementations.silver.king;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 실버 III, 1063번, 킹 문제
public class Main {
    static int[][] Graph = new int[8][8];
    static int[] dx = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = new int[]{0, 0, 1, -1, -1, -1, 1, 1};
    static int[] currentKing;
    static int[] currentStone = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] kingIndex = st.nextToken().split("");
        String[] stoneIndex = st.nextToken().split("");
        currentKing = new int[]{8 - Integer.valueOf(kingIndex[1]),
            -((int) 'A' - kingIndex[0].charAt(0))};
        currentStone = new int[]{8 - Integer.valueOf(stoneIndex[1]),
            -((int) 'A' - stoneIndex[0].charAt(0))};
        Graph[currentKing[0]][currentKing[1]] = 1; // king = 1
        Graph[currentStone[0]][currentStone[1]] = 2; // stone = 2

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            move(cmd);
        }
        StringBuilder sb = new StringBuilder();
        // 킹의 위치
        sb.append((char) ('A' + currentKing[1])).append(8 - currentKing[0]).append("\n");
        // 돌의 위치
        sb.append((char) ('A' + currentStone[1])).append(8 - currentStone[0]).append("\n");
        System.out.println(sb);
    }

    static void draw() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void move(String cmd) {
        int d = whereDirection(cmd);
        int nextX = currentKing[1] + dx[d];
        int nextY = currentKing[0] + dy[d];
        if (nextY >= 0 && nextX >= 0 && nextX < 8 && nextY < 8) {
            if (nextY == currentStone[0] && nextX == currentStone[1]) {
                int stoneNextX = currentStone[1] + dx[d];
                int stoneNextY = currentStone[0] + dy[d];
                if (stoneNextY < 0 || stoneNextX < 0 || stoneNextY >= 8 || stoneNextX >= 8) {
                    return; // 만약 돌이 밖으로 나가면, 로직 실행 X
                }
                Graph[stoneNextY][stoneNextX] = 2;
                currentStone[0] = stoneNextY;
                currentStone[1] = stoneNextX;
            }
            Graph[currentKing[0]][currentKing[1]] = 0;
            Graph[nextY][nextX] = 1;
            currentKing[0] = nextY;
            currentKing[1] = nextX;
        }
    }

    private static int whereDirection(String cmd) {
        if (cmd.equals("R")) {
            return 0;
        } else if (cmd.equals("L")) {
            return 1;
        } else if (cmd.equals("B")) {
            return 2;
        } else if (cmd.equals("T")) {
            return 3;
        } else if (cmd.equals("RT")) {
            return 4;
        } else if (cmd.equals("LT")) {
            return 5;
        } else if (cmd.equals("RB")) {
            return 6;
        } else {
            return 7;
        }
    }

}
