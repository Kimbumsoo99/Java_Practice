package baekjoon.graph.all.g13460.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Beeds {
    int cnt, redY, redX, blueY, blueX;

    public Beeds(int cnt, int redY, int redX, int blueY, int blueX) {
        super();
        this.cnt = cnt;
        this.redY = redY;
        this.redX = redX;
        this.blueY = blueY;
        this.blueX = blueX;
    }

}

public class Main {
    static int N, M, Graph[][];
    static int[] dy = { 0, 0, 1, -1 }, dx = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        Beeds beeds = new Beeds(0, 0, 0, 0, 0);
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[j] == '#') {
                    Graph[i][j] = 1;
                } else if (arr[j] == 'R') {
                    Graph[i][j] = 0;
                    beeds.redY = i;
                    beeds.redX = j;
                } else if (arr[j] == 'B') {
                    Graph[i][j] = 0;
                    beeds.blueY = i;
                    beeds.blueX = j;
                } else if (arr[j] == 'O') {
                    Graph[i][j] = 4;
                }
            }
        }

        int answer = bfs(beeds);
        System.out.println(answer);
    }

    static int bfs(Beeds beeds) {
        ArrayDeque<Beeds> dq = new ArrayDeque<>();
        dq.offer(beeds);

        while (!dq.isEmpty()) {
            Beeds cur = dq.pollFirst();
            if (cur.cnt == 10)
                continue;

            for (int d = 0; d < 4; d++) {
                int rY = cur.redY + dy[d];
                int rX = cur.redX + dx[d];
                int bY = cur.blueY + dy[d];
                int bX = cur.blueX + dx[d];

                // 파란 구슬
                while (Graph[bY][bX] == 0) {
                    bY += dy[d];
                    bX += dx[d];
                }
                if (Graph[bY][bX] == 4) {
                    continue;
                }

                // 빨간 구슬
                while (Graph[rY][rX] == 0) {
                    rY += dy[d];
                    rX += dx[d];
                }
                if (Graph[rY][rX] == 4) {
                    return cur.cnt + 1;
                }



                if (rY == bY && rX == bX) {
                    if (d == 0) { // 좌
                        // redX < blueY
                        if (cur.redX < cur.blueX) {
                            bX -= dx[d];
                        } else {
                            rX -= dx[d];
                        }
                    } else if (d == 1) { // 우
                        if (cur.redX > cur.blueX) {
                            bX -= dx[d];
                        } else {
                            rX -= dx[d];
                        }
                    } else if (d == 2) { // 하
                        if (cur.redY > cur.blueY) {
                            bY -= dy[d];
                        } else {
                            rY -= dy[d];
                        }
                    } else { // 상
                        if (cur.redY < cur.blueY) {
                            bY -= dy[d];
                        } else {
                            rY -= dy[d];
                        }
                    }
                }
                if (rY == cur.redY && rX == cur.redX && bY == cur.blueY && bX == cur.blueX) {
                    continue;
                }
                dq.offer(new Beeds(cur.cnt + 1, rY - dy[d], rX - dx[d], bY - dy[d], bX - dx[d]));
            }
        }

        return -1;
    }
}
