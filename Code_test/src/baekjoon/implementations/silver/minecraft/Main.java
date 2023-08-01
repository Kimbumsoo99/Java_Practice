package baekjoon.implementations.silver.minecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
반례 1 - 250, 35
3 4 11
29 51 54 44
22 44 32 62
25 38 16 2

반례 2 - 355, 32
4 4 36
15 43 61 21
19 33 31 55
48 63 1 30
31 28 3 8
 */
public class Main {

    static int[][] map;
    static int N, M, B;
    static int count = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int sum = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        // 1. 모든 map을 더해서 평균을 구한다.
        int avg = Math.round((float) sum / (N * M));
//        System.out.println((float) sum / (N * M) + " " + avg);

        // 2. 평균값과 근접한 블록으로 맞춘다.
        while (count == -1) {
            count = downMap(avg--);
//            System.out.println(count);
//            drawGraph();
        }
        // 3. 단, 평균값으로 맞추기 위한 블록이 부족한 경우, 한 칸씩 깎는다.

        sb.append(count).append(" ").append(map[0][0]);
        System.out.println(sb);
    }

    static int downMap(int avg){
        int time = 0;
        int Block = B;
        int[][] tmpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = map[i][j];
                if(tmp > avg){
                    int deleteBlock = 0;
                    deleteBlock = tmp - avg;
                    Block += deleteBlock;
                    time += (deleteBlock * 2);
                    tmp -= deleteBlock;
                } else if (tmp < avg) {
                    int addBlock = avg - tmp;
                    if (B - addBlock < 0) {
                        System.out.println(tmp + " " + avg + " " + B + " " + addBlock);
                        return -1;
                    }
                    Block -= addBlock;
                    time += addBlock;
                    tmp += addBlock;
                }
                tmpMap[i][j] = tmp;
            }
        }
        B = Block;
        map = tmpMap;
        return time;
    }

    static void drawGraph() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
