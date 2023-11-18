package baekjoon.implementations.gold.snake_ladder_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[][] Graph = new int[10][10];
    static int[][] dp = new int[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                Graph[i][j] = count++;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < ladder; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; // 사다리 시작
            int y = Integer.parseInt(st.nextToken()) - 1; // 사다리 끝
            Graph[x / 10][x % 10] = y; // 36, 64가 들어오면 Graph[3][6] = 64
        }

        for (int i = 0; i < snake; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1; // 뱀 시작
            int y = Integer.parseInt(st.nextToken()) - 1; // 뱀 끝
            Graph[x / 10][x % 10] = y;
        }
//        draw();

        int answer = solution();
        System.out.println(answer);
    }

    static int bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0}); // 위치, 카운트
        int count = Integer.MAX_VALUE;
        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
//            System.out.println(tmp[0] + " " + tmp[1]);
            for (int i = 1; i <= 6; i++) {
                int nextX = tmp[0] + i;
                if (nextX < 99 && dp[nextX / 10][nextX % 10] > tmp[1] + 1) { // 앞자리수가 바꼈다면
                    dq.offer(new int[]{Graph[nextX / 10][nextX % 10], tmp[1] + 1});
                    dp[nextX / 10][nextX % 10] = tmp[1] + 1;
                } else if (nextX == 99) {
                    count = Math.min(count, tmp[1] + 1);
                }
            }
        }

        return count;
    }

    static int solution() {
        int count = 0;
        int current = 0;
        while (true) {

            int max = 0;
            for (int i = 6; i >= 1; i--) {
                if (current + i < 99) {
                    max = Math.max(Graph[(current + i) / 10][(current + i) % 10], max);
                } else if (current + i == 99) {
                    return count + 1;
                }
            }
            current = max;
            count++;
        }
    }

    private static void draw() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
