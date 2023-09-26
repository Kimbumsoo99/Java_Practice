package baekjoon.implementations.silver.bomberman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int Y;
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Graph = new int[Y][X];
        int T = Integer.parseInt(st.nextToken()) - 1; // 1초는 생략
        for (int i = 0; i < Y; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                if (str[j].equals(".")) {
                    Graph[i][j] = -1;
                } else {
                    Graph[i][j] = 2;
                }
            }
        }
        T = T % 8;
        for (int i = 0; i < T; i++) {
            if (i % 2 == 0) {
                create();
            } else {
                bomb();
            }
//            drawNum();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (Graph[i][j] < 0) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void draw() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (Graph[i][j] == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    static void drawNum() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(Graph[i][j] + " \t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void create() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (Graph[i][j] == -1) {
                    Graph[i][j] = 3;
                } else {
                    Graph[i][j]--;
                }
            }
        }
    }


    private static void bomb() {
        ArrayList<int[]> bombList = new ArrayList<>();
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (Graph[i][j] != -1) {
                    Graph[i][j]--;
                    if (Graph[i][j] == 0) {
                        bombList.add(new int[]{i, j});
                    }
                }
            }
        }
        Iterator<int[]> it = bombList.iterator();
        while (it.hasNext()) {
            int[] tmp = it.next();
            Graph[tmp[0]][tmp[1]] = -1;
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < X && nextY < Y) {
                    if (Graph[nextY][nextX] > 0) {
                        Graph[nextY][nextX] = -1;
                    }
                }
            }
        }
    }
}
