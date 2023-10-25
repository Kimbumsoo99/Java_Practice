package baekjoon.implementations.silver.s10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visit;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int direction = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        if (K > C * R) {
            System.out.println(0);
            System.exit(0);
        }
        visit = new boolean[C][R];
        int[] answer = find(K);
        System.out.println((answer[0] + 1) + " " + (answer[1] + 1));
    }

    private static int[] find(int k) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        visit[0][0] = true;
        int count = 1;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (count == k) {
                return tmp;
            }
            int nextY = tmp[0] + dy[direction];
            int nextX = tmp[1] + dx[direction];
            if (nextY < 0 || nextX < 0 || nextY >= visit.length || nextX >= visit[0].length
                || visit[nextY][nextX]) {
                direction += 1;
                if (direction == 4) {
                    direction = 0;
                }
                nextY = tmp[0] + dy[direction];
                nextX = tmp[1] + dx[direction];
            }
            dq.offer(new int[]{nextY, nextX});
            visit[nextY][nextX] = true;
            count++;
        }
        return null;
    }


}
