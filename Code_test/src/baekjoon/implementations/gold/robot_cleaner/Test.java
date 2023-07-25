package baekjoon.implementations.gold.robot_cleaner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 실수로 로봇이 앞을 닦을 수 있다면 닦게 구현했음.
 * 실제로는 4 방향중 하나라도 빈 곳이 있다면 돌게 하는 것
 */
public class Test {
    // 0 ↑ , 1 → , 2 ↓ , 3 ←
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] Graph;
    static boolean[][] cleaned;
    static int count = 0;

    static void autoClean(int x, int y, int d){
        System.out.println(y + " " + x + " " + Graph[y][x]);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, d});
        while (true) {
            int[] tmp = q.poll();


            // 현재칸 청소
            if(!cleaned[tmp[0]][tmp[1]]){
                count++;
                cleaned[tmp[0]][tmp[1]] = true;
            }

            // 현재칸 주변 4칸 확인
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[(i + tmp[2]) % 4];
                int nextY = tmp[0] + dy[(i + tmp[2]) % 4];
                if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph[0].length) {
                    if (!cleaned[nextY][nextX] && Graph[nextY][nextX] == 0) {
                        q.offer(new int[]{nextY, nextX, (i + tmp[2]) % 4});
                        System.out.println(nextY + " " + nextX + " " + Graph[nextY][nextX]);
                        break;
                    }
                }
            }

            if (q.isEmpty()) {
                System.out.println("   " + tmp[0] + " " + tmp[1] + " " + Graph[tmp[0]][tmp[1]]);
                q.offer(new int[]{tmp[0] + dy[(2 + tmp[2]) % 4], tmp[1] + dx[(2 + tmp[2]) % 4], tmp[2]});
                if (Graph[tmp[0] + dy[(2 + tmp[2]) % 4]][tmp[1] + dx[(2 + tmp[2]) % 4]] == 1) {
                    return;
                }
            }


        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Graph = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        autoClean(startX, startY, d);
        System.out.println(count);
    }
}
