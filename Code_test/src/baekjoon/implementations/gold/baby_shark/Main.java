package baekjoon.implementations.gold.baby_shark;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static int size = 2;

    static void drowGraph(){
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph.length; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Graph = new int[N][N];
        visit = new boolean[N][N];
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                Graph[i][j] = tmp != 9 ? tmp : -1;
                if (tmp == 9) {
                    start = new int[]{i, j};
                }

            }
        }
        int answer = bfs(start);
        System.out.println(answer);
    }

    static int bfs(int[] start) {
        int time = 0;
        int hungry = 0;
//        System.out.println(start[0] + " " + start[1]);
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{start[0], start[1], 0, start[0], start[1]}); // dq Y, dq X, time, 상어 Y, 상어 X
        visit[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph.length) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] <= size) {
                        if (Graph[nextY][nextX] != size && Graph[nextY][nextX] != 0) {
//                            System.out.println(Graph[nextY][nextX]);
//                            System.out.println(isEat(dq, tmp[2]));
                            tmp = isEat(dq, new int[]{nextY, nextX, tmp[2], tmp[3], tmp[4]});
                            nextY = tmp[0];
                            nextX = tmp[1];
                            Graph[tmp[3]][tmp[4]] = 0;
                            Graph[nextY][nextX] = -1;

                            time += tmp[2] + 1;

                            hungry++;
                            if (hungry == size) {
                                size++;
                                hungry = 0;
                            }

//                            System.out.println(
//                                tmp[0] + " " + tmp[1] + " " + nextY + " " + nextX + " " + time);
//                            drowGraph();

                            visit = new boolean[Graph.length][Graph.length];
                            dq.clear();
                            dq.offerLast(new int[]{nextY, nextX, 0, nextY, nextX});
                            visit[nextY][nextX] = true;
                            break;
                        } else {
                            visit[nextY][nextX] = true;
                            dq.offerLast(new int[]{nextY, nextX, tmp[2] + 1, tmp[3], tmp[4]});
                        }
                    }
                }
            }
        }
        return time;
    }
    static int[] isEat(ArrayDeque<int[]> dq,  int[] current){
//        System.out.println("시작 " + current[0] + " " + current[1] + " ");
        int changeX = current[1];
        int changeY = current[0];
        for(int[] tmp : dq){
            if (tmp[2] <= current[2]){
                for (int i = 0; i < 4; i++) {
                    int nextX = tmp[1] + dx[i];
                    int nextY = tmp[0] + dy[i];

                    if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph.length) {
                        if (!visit[nextY][nextX] && Graph[nextY][nextX] <= size) {
                            if (Graph[nextY][nextX] < size && Graph[nextY][nextX] != 0) {
//                                System.out.println( " 함수 안 " +
//                                    tmp[0] + " " + tmp[1] + " " + nextY + " " + nextX + " " + changeY);
                                if (changeY > nextY) {
//                                    System.out.println( " 함수 안 " +
//                                        tmp[0] + " " + tmp[1] + " " + nextY + " " + nextX + " " + changeY);
                                    changeY = nextY;
                                    changeX = nextX;
//                                    return new int[]{changeY, changeX};
                                } else if (changeY == nextY && changeX > nextX) {
                                    changeY = nextY;
                                    changeX = nextX;
                                }
                            }
                        }
                    }
                }
            }
        }
        return new int[]{changeY, changeX, current[2], current[3], current[4]};
    }

}
