package baekjoon.implementations.gold.g18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

// 경쟁적 전염, 골드 V, 18405번
public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static ArrayList<int[]> list = new ArrayList<>();
    static int Y;
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Y;
        int K = Integer.parseInt(st.nextToken());
        Graph = new int[Y][X];
        visit = new boolean[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                int N = Integer.parseInt(st.nextToken());
//                System.out.print(N + " ");
                Graph[i][j] = N;
                if (Graph[i][j] != 0) {
                    list.add(new int[]{Graph[i][j], i, j});
                    visit[i][j] = true;
                }
            }
//            System.out.println();
        }
        if (list.size() > 1) {
            Collections.sort(list, ((o1, o2) -> {
                return o1[0] - o2[0];
            }));
        }
        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int findY = Integer.parseInt(st.nextToken()) - 1;
        int findX = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < time; i++) {
//            draw();
            if (list.size() == 0) {
                break;
            }
            spreadOne(list);
        }
//        draw();
        System.out.println(Graph[findY][findX]);
    }

    static void spreadOne(ArrayList<int[]> preList) {
        ArrayList<int[]> spread = new ArrayList<>();
        for (int[] value : preList) {
            for (int k = 0; k < 4; k++) {
                int nextY = value[1] + dy[k];
                int nextX = value[2] + dx[k];
                if (nextY >= 0 && nextX >= 0 && nextX < X && nextY < Y) {
                    if (!visit[nextY][nextX]) { // 방문하지 않았고,
                        Graph[nextY][nextX] = value[0];
                        visit[nextY][nextX] = true;
                        spread.add(new int[]{value[0], nextY, nextX});
                    }
                }
            }
        }
        if (list.size() > 1) {
            Collections.sort(preList, ((o1, o2) -> {
                return o1[0] - o2[0];
            }));
        }
        list = spread;
    }
    static void draw() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
