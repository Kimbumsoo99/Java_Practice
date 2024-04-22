package baekjoon.graph.bfs.g1938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Train {
    int[] mid;
    int turn = 0, cnt = 0;

    @Override
    public String toString() {
        return "Train{" +
                "mid=" + Arrays.toString(mid) +
                ", turn=" + turn +
                ", cnt=" + cnt +
                '}';
    }
}
public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 }, dy = new int[]{1, -1, 0, 0};

    static int N, Graph[][], endT;
    static ArrayList<int[]> end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        Graph = new int[N][N];

        ArrayList<int[]> start = new ArrayList<>();
        end = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (tmp[j] == 'B') {
                    start.add(new int[] { i, j });
                } else if (tmp[j] == 'E') {
                    end.add(new int[] { i, j });
                    Graph[i][j] = 2;
                } else {
                    Graph[i][j] = tmp[j] - '0';
                }
            }
        }

        Train cur = new Train();
        cur.mid = start.get(1);
        if (start.get(0)[0] == start.get(1)[0]) { // 가로
            cur.turn = 0;
        } else { // 세로
            cur.turn = 1;
        }

        if (end.get(0)[0] == end.get(1)[0]) { // 가로
            endT = 0;
        } else { // 세로
            endT = 1;
        }
        System.out.println(bfs(cur));
    }


    static int bfs(Train start){
        ArrayDeque<Train> dq = new ArrayDeque<>();
        dq.offer(start);
        boolean[][][] visit = new boolean[2][N][N];
        visit[start.turn][start.mid[0]][start.mid[1]] = true;
        while (!dq.isEmpty()) {
            Train cur = dq.poll();
            if(finish(cur)) return cur.cnt;

            for (int i = 0; i < 4; i++) {
                int nextY = cur.mid[0] + dy[i];
                int nextX = cur.mid[1] + dx[i];
                if (isMap(nextY, nextX, cur.turn) && !visit[cur.turn][nextY][nextX]) {
                    if ((cur.turn == 1 && Graph[nextY][nextX] != 1 && Graph[nextY - 1][nextX] != 1 && Graph[nextY + 1][nextX] != 1) || (cur.turn == 0 && Graph[nextY][nextX] != 1 && Graph[nextY][nextX - 1] != 1 && Graph[nextY][nextX + 1] != 1)) {
                        Train train = new Train();
                        train.turn = cur.turn;
                        train.cnt = cur.cnt + 1;
                        train.mid = new int[]{nextY, nextX};
                        dq.offer(train);
                        visit[cur.turn][nextY][nextX] = true;
                    }
                }
            }

            boolean turnFlag = true;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!isMap(cur.mid[0] + i, cur.mid[1] + j) || Graph[cur.mid[0] + i][cur.mid[1] + j] == 1) {
                        turnFlag = false;
                    }
                }
            }
            if (cur.turn == 1) { // 세로 -> 가로
                cur.turn = 0;
            } else { // 가로 -> 세로
                cur.turn = 1;
            }

            if (!turnFlag || visit[cur.turn][cur.mid[0]][cur.mid[1]]) {
                continue;
            }
            Train train = new Train();
            train.turn = cur.turn;
            train.mid = cur.mid;
            train.cnt = cur.cnt + 1;
            dq.offer(train);
            visit[cur.turn][cur.mid[0]][cur.mid[1]] = true;
        }
        return 0;
    }
    static boolean finish(Train cur){
        if (cur.turn == 1) {
            if (Graph[cur.mid[0]][cur.mid[1]] == 2 && Graph[cur.mid[0] - 1][cur.mid[1]] == 2 && Graph[cur.mid[0] + 1][cur.mid[1]] == 2) {
                return true;
            }
        } else {
            if (Graph[cur.mid[0]][cur.mid[1]] == 2 && Graph[cur.mid[0]][cur.mid[1] - 1] == 2 && Graph[cur.mid[0]][cur.mid[1] + 1] == 2) {
                return true;
            }
        }
        return false;
    }
    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
    static boolean isMap(int y, int x, int turn) {
        if (turn == 1) {
            return y - 1 >= 0 && x >= 0 && y + 1 < N && x < N;
        } else {
            return y >= 0 && x - 1 >= 0 && y < N && x + 1 < N;
        }
    }
}
