package baekjoon.implementations.silver.minecraft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainBrute {
    static int[][] map;
    static int N, M, B;
    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (min > map[i][j]) {
                    min = map[i][j];
                }
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int i = min; i < max + 1; i++) {
            int tmp[] = craft(i);
            if (time > tmp[0] && tmp[0] >= 0) {
                time = tmp[0];
                height = tmp[1];
            } else if (time == tmp[0] && height < tmp[1]) {
                height = tmp[1];
            }
        }
        sb.append(time).append(" ").append(height);
        System.out.println(sb);
    }

    static int[] craft(int height) {
        int answer[] = new int[]{0, height}; // [0] time, [1] height
        int block = B;
        int time = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] < height) {
                    int addBlock = height - map[i][j];
                    block -= addBlock;
//                    당장 블록이 부족해도 다른 곳에서 퍼오면 가능할 수 있음.
//                    if (block < 0) {
//                        return new int[]{-1, -1};
//                    }
                    time += addBlock;
                } else if (map[i][j] > height) {
                    int removeBlock = map[i][j] - height;
                    block += removeBlock;
                    time += (removeBlock * 2);
                }
            }
        }
        if (block < 0) {
            return new int[]{-1, -1};
        }
        answer[0] = time;
        return answer;
    }
}
