package baekjoon.implementations.gold.iceberg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 갈아엎고 다시시작

// 감소시키는 decrease함수도 따로만드는 것이아니라 bfs함수를 돌면서 빙산 주위의 바다개수를 구하여 저장한뒤 모든 탐색이 끝난 후
// 바다 개수만큼 빙산 높이를 낮춰 준다

public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int N;
    static int M;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int[]> iceberg = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (Graph[i][j] > 0) {
                    iceberg.add(new int[]{i, j});
                }
            }
        }
        int year = 0;
        int iceNum = 0;
        while (true) {
            visit = new boolean[N][M];
            for (int ice[] : iceberg) {
                int tx = ice[1];
                int ty = ice[0];
                if (!visit[ty][tx] && Graph[ty][tx] > 0) {
                    bfs(ty, tx);
                    iceNum++;
                }
                if (iceNum > 1) {
                    break;
                }
            }

            for (int i = iceberg.size() - 1; i >= 0; i--) {
                int[] ice = iceberg.get(i);
                Graph[ice[0]][ice[1]] = isHigher(ice[0], ice[1]);
            }

            for (int i = iceberg.size() - 1; i >= 0; i--) {
                int[] ice = iceberg.get(i);
                if (Graph[ice[0]][ice[1]] == -1) {
                    iceberg.remove(i);
                }
            }
//            System.out.println(iceberg.size());
            if (iceberg.size() == 0) {
                year = 0;
                break;
            }

            year++;
            iceNum = 0;
        }
        bw.write(year + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int isHigher(int y, int x){
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                if (Graph[nextY][nextX] == 0) {
                    Graph[y][x]--;
                    if (Graph[y][x] < 1) {
                        return -1;
                    }
                }
            }
        }
        return Graph[y][x];
    }


    static void bfs(int y, int x) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{y, x});
        visit[y][x] = true;
        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] > 0) {
                        dq.offerLast(new int[]{nextY, nextX});
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
    }

}
