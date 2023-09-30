package baekjoon.dfs.s2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 영역 구하기, 실버 I, 2583
public class Main {
    static boolean[][] visit;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int fX = Integer.parseInt(st.nextToken());
            int fY = Integer.parseInt(st.nextToken());
            for (int j = sY; j < fY; j++) {
                for (int k = sX; k < fX; k++) {
//                    System.out.println(j + " " + k);
                    if (!visit[j][k]) {
                        visit[j][k] = true;
                    }
                }
            }
        }
//        draw();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    count++;
                    int tmp = bfs(i, j);
                    list.add(tmp);
//                    draw();
                }
            }
        }
        Collections.sort(list);
        sb.append(count).append("\n");
        for (Integer tmp : list) {
            sb.append(tmp).append(" ");
        }
        System.out.println(sb);
    }
    static void draw() {
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                System.out.print(visit[i][j] + "   \t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int bfs(int y, int x) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x});
        visit[y][x] = true;
        int count = 1;
        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextY < visit.length && nextX < visit[0].length) {
                    if (!visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        count++;
                        dq.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
        return count;
    }

}
