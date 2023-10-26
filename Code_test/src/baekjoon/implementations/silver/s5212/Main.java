package baekjoon.implementations.silver.s5212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] area;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static ArrayList<int[]> areaList = new ArrayList<>();
    static int top = 11;
    static int bottom = -1;
    static int left = 11;
    static int right = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        area = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (tmp.charAt(j) == 'X') {
                    area[i][j] = true;
                    areaList.add(new int[]{i, j});
                }
            }
        }
        layer();
        draw();
    }

    private static void draw() {
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (area[i][j]) {
                    System.out.print('X');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

    static void layer() {
        ArrayList<int[]> change = new ArrayList<>();
        for (int[] r : areaList) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nextY = r[0] + dy[i];
                int nextX = r[1] + dx[i];
                if (nextY < 0 || nextX < 0 || nextY >= area.length || nextX >= area[0].length
                    || !area[nextY][nextX]) {
                    count++;
                }
            }
            if (count > 2) {
                change.add(r);
            } else {
                top = Math.min(top, r[0]);
                bottom = Math.max(bottom, r[0]);
                left = Math.min(left, r[1]);
                right = Math.max(right, r[1]);
            }
        }

        for (int[] r : change) {
            area[r[0]][r[1]] = false;
        }
    }

}
