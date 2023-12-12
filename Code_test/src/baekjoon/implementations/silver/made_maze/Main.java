package baekjoon.implementations.silver.made_maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int topXIndex = 50;
    static int topYIndex = 50;
    static int bottomXIndex = 50;
    static int bottomYIndex = 50;
    static int currentX = 50;
    static int currentY = 50;
    static int[] dx = new int[]{0, 1, 0, -1}; // 하, 우, 상, 좌
    static int[] dy = new int[]{1, 0, -1, 0};
    static int direction = 0;
    static boolean[][] visit = new boolean[103][103];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> command = new ArrayList<>();
        String cmd = br.readLine();
        for (int i = 0; i < N; i++) {
            char c = cmd.charAt(i);
            int tmp;
            if (c == 'L') {
                tmp = 1;
            } else if (c == 'R') {
                tmp = -1;
            } else {
                tmp = 0;
            }
            command.add(tmp); // 0 직진, 1 왼쪽, -1 오른쪽
        }
        visit[currentY][currentX] = true;
        for (Integer c : command) {
            if (c != 0) {
                direction += c;
                if (direction < 0) {
                    direction = 3;
                } else if (direction > 3) {
                    direction = 0;
                }
            } else {
                currentX += dx[direction];
                currentY += dy[direction];
                visit[currentY][currentX] = true;
                topXIndex = Math.max(topXIndex, currentX);
                topYIndex = Math.max(topYIndex, currentY);
                bottomXIndex = Math.min(bottomXIndex, currentX);
                bottomYIndex = Math.min(bottomYIndex, currentY);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bottomYIndex; i < topYIndex + 1; i++) {
            for (int j = bottomXIndex; j < topXIndex + 1; j++) {
                if (visit[i][j]) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

}
