package baekjoon.implementations.gold.dust_bye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer[][] Graph;
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Integer airX, airY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        Graph = new Integer[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (Graph[i][j] == -1) {
                    if(airX == null){
                        airX = i;
                    }else{
                        airY = i;
                    }
                }
            }
        }

        for (int i = 0; i < second; i++) {
            dustMove();
//            System.out.println(" 먼지 이동 ");
//            drawGraph(Graph);
            airRobot();
//            System.out.println(" 공기청정기 ");
//            drawGraph(Graph);
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(Graph[i][j] > 0){
                    answer += Graph[i][j];
                }
            }
        }
        System.out.println(answer);
    }

    static void dustMove(){
        Integer[][] newGraph = new Integer[N][M];
        newGraph[airX][0] = -1;
        newGraph[airY][0] = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newGraph[i][j] == null) {
                    newGraph[i][j] = 0;
                }

                if (Graph[i][j] > 0) {
                    int addDust = Graph[i][j] / 5;
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = j + dx[k];
                        int nextY = i + dy[k];
                        if (nextY < 0 || nextX < 0 || nextX >= M || nextY >= N) {
                            continue;
                        }
                        if (Graph[nextY][nextX] == -1) {
                            continue;
                        }
                        count++;
                        if(newGraph[nextY][nextX] == null){
                            newGraph[nextY][nextX] = addDust;
                        }else{
                            newGraph[nextY][nextX] += addDust;
                        }
                    }
                    newGraph[i][j] += (Graph[i][j] - addDust * count);
                }
            }
        }
        Graph = newGraph;
    }

    static void airRobot(){
        airUpStart(airX, new int[]{0, 1, 0, -1}, new int[]{-1, 0, 1, 0});
        airDownStart(airY, new int[]{0, 1, 0, -1}, new int[]{1, 0, -1, 0});
    }

    static void airUpStart(int air, int[] ddx, int[] ddy){
        int idx = 0;
        int[] start = new int[]{air + ddy[idx], 0};
        Graph[start[0]][start[1]] = 0;

        while (true) {
//            System.out.println(start[0] + " " + start[1]);
            int nextX = start[1] + ddx[idx];
            int nextY = start[0] + ddy[idx];
            if (nextY == air && nextX == 0) {
                Graph[start[0]][start[1]] = 0;
                break;
            }
            if (nextY < 0 || nextY > air || nextX < 0 || nextX >= M) {
                idx++;
                continue;
            }
            Graph[start[0]][start[1]] = Graph[nextY][nextX];
            start[0] = nextY;
            start[1] = nextX;
        }
    }

    static void airDownStart(int air, int[] ddx, int[] ddy){
        int idx = 0;
        int[] start = new int[]{air + ddy[idx], 0};
        Graph[start[0]][start[1]] = 0;

        while (true) {
//            System.out.println(start[0] + " " + start[1]);
            int nextX = start[1] + ddx[idx];
            int nextY = start[0] + ddy[idx];
            if (nextY == air && nextX == 0) {
                Graph[start[0]][start[1]] = 0;
                break;
            }
            if (nextY < air || nextY >= N || nextX < 0 || nextX >= M) {
                idx++;
                continue;
            }
            Graph[start[0]][start[1]] = Graph[nextY][nextX];
            start[0] = nextY;
            start[1] = nextX;
        }
    }


    static void drawGraph(Integer[][] g){
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
