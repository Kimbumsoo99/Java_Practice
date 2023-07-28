package baekjoon.implementations.gold.people_move;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int L;
    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<ArrayList<int[]>> unionList = new ArrayList<>();
        while (unionList.isEmpty()) {
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        unionList.add(bfs(i, j));
                    }
                }
            }
        }
    }

    static ArrayList<int[]> bfs(int y, int x){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        ArrayList<int[]> union = new ArrayList<>();
        dq.offerLast(new int[]{y, x, Graph[y][x]});
        union.add(new int[]{y, x, Graph[y][x]});
        visit[y][x] = true;
        int sum = Graph[y][x];
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];

                if (nextY >= 0 && nextX >= 0 && nextX < Graph.length && nextY < Graph.length) {
                    int p = Math.abs(Graph[tmp[0]][tmp[1]] - Graph[nextY][nextX]);
                    if (p >= L && p <= R) {
                        // 1. 국경선안에 존재한다면, dq에 넣는다.
                        dq.offerLast(new int[]{nextY, nextX, Graph[y][x]});
                        // 2. visit[nY][nX] = true하면서 국경선끼리의 연합을 만든다.
                        visit[nextY][nextX] = true;
                        // 3. 이때 각각의 dq 연합에 대하여, 합을 만든다.
                        sum += Graph[nextY][nextX];
                        union.add(new int[]{nextY, nextX, sum});
                    }
                }
            }
        }
        return union;
        // 연합의 합을 연합 국가 수만큼 나눈 뒤, 각각의 그래프 좌표에 저장한다.
//        sum = (int) sum / unionList.size();
//        Iterator<int[]> it = unionList.iterator();
//        while (it.hasNext()) {
//            int[] tmp = it.next();
//            Graph[tmp[0]][tmp[1]] = sum;
//        }
    }
}
