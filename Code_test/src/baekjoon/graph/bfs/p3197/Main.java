package baekjoon.graph.bfs.p3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백조 L : 2
 * 빙산 X : 1
 */
class See {
    int y, x, cnt, idx;

    public See(int y, int x, int cnt, int idx) {
        super();
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.idx = idx;
    }

    public See() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "See [y=" + y + ", x=" + x + ", cnt=" + cnt + ", idx=" + idx + "]";
    }

}

public class Main {
    static int N, M, Graph[][], parents[];
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    static ArrayDeque<See> dq = new ArrayDeque<>();
    static boolean[][] visit;
    static ArrayList<Integer> swan = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new int[N][M];
        makeSet();
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (arr[j] == 'L') {
                    Graph[i][j] = 0;
                    swan.add(i * M + j);
                    dq.offer(new See(i, j, 0, i * M + j));
                } else if (arr[j] == 'X') {
                    Graph[i][j] = 1;
                } else {
                    dq.offer(new See(i, j, 0, i * M + j));
                }
            }
        }

        // 물로 시작해서 빙하 녹이기
        // 백조가 둘이 맞닿은 경우 -> 같은 물의 집합으로 연결된 경우?
        // 모든 물을 ArrayDeque에 집어넣고, 탐색 시작하기
        // 상하좌우 탐색하며, 물이있다면, union()을 통해 같은 물로 합침.
        // 만약 같은 물이었다면, 이는 Q에 넣지 않음.
        // 빙하라면, 빙하를 녹이는 물의 부모로 값을 세팅
        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<int[]> ice = new ArrayDeque<>();
        int cnt = 0;
        while (true) {
            int size = dq.size();
            if (findSet(parents[swan.get(0)]) == findSet(parents[swan.get(1)]))
                return cnt;

            while (size-- > 0) {
                See tmp = dq.pollFirst();
                for (int i = 0; i < 4; i++) {
                    int nextY = tmp.y + dy[i];
                    int nextX = tmp.x + dx[i];
                    if (isMap(nextY, nextX)) {
                        if (unionSet(findSet(tmp.idx), findSet(nextY * M + nextX))) {
                            if (Graph[nextY][nextX] == 1) {
                                ice.offer(new int[] { nextY, nextX, cnt + 1 });
//								dq.offer(new See(nextY, nextX, tmp.cnt + 1, nextY * M + nextX));
                            }
                        }
                    }
                }
            }
            while (!ice.isEmpty()) {
                int[] tmp = ice.pollFirst();
                if (Graph[tmp[0]][tmp[1]] == 1) {
                    Graph[tmp[0]][tmp[1]] = 0;
                    dq.offer(new See(tmp[0], tmp[1], tmp[2], tmp[0] * M + tmp[1]));
                    for (int i = 0; i < 4; i++) {
                        int nextY = tmp[0] + dy[i];
                        int nextX = tmp[1] + dx[i];
                        if (isMap(nextY, nextX) && Graph[nextY][nextX] == 0) {
                            unionSet(findSet(tmp[0] * M + tmp[1]), findSet(nextY * M + nextX));
                        }
                    }
                }
            }
            cnt++;
        }
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }

    static void makeSet() {
        parents = new int[N * M + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = findSet(parents[x]);
    }

    static boolean unionSet(int x, int p) {
        if (x == p)
            return false;
        if (x < p) { // parents가 최대한 작게 만들기
            int tmp = p;
            p = x;
            x = tmp;
        }
        parents[x] = p;
        return true;
    }

}
