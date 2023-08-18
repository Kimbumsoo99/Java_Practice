package baekjoon.implementations.gold.cheese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    // 외부공기를 탐색하면서, cheese를 찾는다.
    // 외부공기에 대한 bfs를 하면서, cheese를 만나면 치즈 카운팅
    // 공기를 두번 만나면 지우고, 아니라면 유지

    static int[][] Graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (!isCheeseEmpty()) {
            day++;
            bfs();
        }

        System.out.println(day);
    }

    static boolean isCheeseEmpty(){
        for (int i = 1; i < Graph.length - 1; i++) {
            for (int j = 1; j < Graph[0].length - 1; j++) {
                if (Graph[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void bfs(){
        HashSet<int[]> removeCheese = new HashSet<>();
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        dq.offer(new int[]{0, 0});
        visit[0][0] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextX < M && nextY < N) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] == 1) {
                        visit[nextY][nextX] = true;
                    } else if (!visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX});
                    } else if (visit[nextY][nextX] && Graph[nextY][nextX] == 1) {
                        // 치즈를 방문했었으면, -> 두 번 외부 공기에 닿았음.
                        removeCheese.add(new int[]{nextY, nextX});
                    }
                }
            }
        }

        Iterator<int[]> it = removeCheese.iterator();
        while (it.hasNext()) {
            int tmp[] = it.next();
            Graph[tmp[0]][tmp[1]] = 0;
        }
    }
}
