package baekjoon.brouteforce.candy_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static int answer = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                String tmp = st[j];
                map[i][j] = tmp;
            }
        }


        for (int i = 0; i < N; i++) {
            if (answer == N) {
                break;
            }
            for (int j = 0; j < N; j++) {
                solution(i, j, N, 0); // 행, 열
            }
        }
        System.out.println(answer);
    }

    static void solution(int y, int x, int N, int depth){
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextY >= 0 && nextX >= 0 && nextX < N && nextY < N) {
                if (!map[y][x].equals(map[nextY][nextX])) {
                    answer = Math.max(answer, swap(y, x, nextY, nextX));
                    if (answer == N) {
                        return;
                    }
                }
            }
        }
    }
    static void draw(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int swap(int r1, int c1, int r2, int c2){
        String tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
//        draw();

        int maxCount = 0;
        // 행 비교
        for (int i = 0; i < map.length; i++) {
            String current = map[i][0];
            int count = 1;
            for (int j = 1; j < map.length; j++) {
                if (current.equals(map[i][j]) && j == map.length - 1) {
                    maxCount = maxCount < count + 1 ? count + 1 : maxCount;
                    count = 1;
                } else if (current.equals(map[i][j])) {
                    count++;
                } else {
                    maxCount = maxCount < count ? count : maxCount;
                    count = 1;
                    current = map[i][j];
                }
            }
        }

        // 열 비교
        for (int i = 0; i < map.length; i++) {
            String current = map[0][i];
            int count = 1;
            for (int j = 1; j < map.length; j++) {
                if (current.equals(map[j][i]) && j == map.length - 1) {
                    maxCount = maxCount < count + 1 ? count + 1 : maxCount;
                    count = 1;
                }
                else if (current.equals(map[j][i])) {
                    count++;
                }else {
                    maxCount = maxCount < count ? count : maxCount;
                    count = 1;
                    current = map[j][i];
                }
            }
        }
//        System.out.println(maxCount);

        tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;

        return maxCount;
    }
}
