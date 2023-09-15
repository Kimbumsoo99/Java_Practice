package baekjoon.implementations.silver.snail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] Graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int findX;
    static int findY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        int start[] = new int[]{N / 2, N / 2};
        FillGraph(start, find);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(Graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        if (find == 1) {
            findY = start[0];
            findX = start[1];
        }
        sb.append(findY + 1).append(" ").append(findX + 1);
        System.out.println(sb);
    }

    static void FillGraph(int[] start, int find) {
        // 위 1, 오 preTile, 아 currentTile - 1 왼 위
        int direction = 0; // 0 위, 1 오, 2 아, 3 왼
        int num = 1;
        Graph[start[0]][start[1]] = num++;
        int currentX = start[1];
        int currentY = start[0];
        int preTile = 1;
        int currentTile = 1;
        while (num <= (Graph.length * Graph.length)) {
            // currentTile 증가
            direction = 0;
            currentTile += 2;

            // 외곽 그래프 그리기
//            System.out.println("현재 위치 " + currentY + " " + currentX + " " + currentTile);
            int count;
            for (int i = 0; i < 5; i++) {
                if (i == 0) {
                    count = 1;
                } else if (i == 1) {
                    count = preTile;
                }else {
                    count = currentTile - 1;
                }
                while (count > 0) {
                    // 그래프 채우기
                    currentX += dx[direction];
                    currentY += dy[direction];
                    if (num == find) {
                        findX = currentX;
                        findY = currentY;
                    }
//                    System.out.println(currentY + " " + currentX + " " + num);
                    Graph[currentY][currentX] = num++;
                    count--;
                }

                // 방향 전환 위 -> 오 -> 아 -> 왼 -> 위
                direction = (direction + 1) % 4;
            }

            // preTile 변경
            preTile = currentTile;
        }
    }

}
