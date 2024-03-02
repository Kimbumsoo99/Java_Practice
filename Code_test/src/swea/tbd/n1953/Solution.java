package swea.tbd.n1953;

// BFS로 너비만큼 완탐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();
    static int N,M,Graph[][], start[], L;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0}; // 상,하,좌,우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Graph = new int[N][M];
            start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            L = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = bfs(start);
            sb.append("#" + test_case + " " + answer + "\n");
        }
        System.out.println(sb);
    }
    static int bfs(int[] start){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        visit[start[0]][start[1]] = true;
        int cnt = 0;
        int time = 1;
        dq.offer(start);
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] tmp = dq.pollFirst();
                int pipe = Graph[tmp[0]][tmp[1]];
                cnt++;
                for (int d = 0; d < 4; d++) {
                    int nextY = tmp[0] + dy[d];
                    int nextX = tmp[1] + dx[d];
                    if (isMap(nextY, nextX) && !visit[nextY][nextX] && Graph[nextY][nextX] != 0
                        && canGo(pipe, d)) {
                        int nPipe = Graph[nextY][nextX];
                        if (canCome(nPipe, d)) {
                            visit[nextY][nextX] = true;
                            dq.offer(new int[]{nextY, nextX});
                        }
                    }
                }
            }
            if (time++ == L) {
                break;
            }
        }
        return cnt;
    }

    // 현재 위치에서 갈 수 있는지?
    // pipe 형태, dir 방향
    static boolean canGo(int pipe, int dir) {
        if (dir == 0) { // 상, 가능
            return pipe == 1 || pipe == 2 || pipe == 4 || pipe == 7;
        } else if (dir == 1) { // 하, 가능
            return pipe == 1 || pipe == 2 || pipe == 5 || pipe == 6;
        } else if (dir == 2) { // 좌, 가능
            return pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7;
        } else if (dir == 3) { // 우, 가능
            return pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5;
        }
        return false;
    }

    // 다음 위치에서는 받을 수 있는지?
    // canGo와 비슷하지만, 반대로 생각하기
    static boolean canCome(int pipe, int dir) {
        if (dir == 0) { // 상, 아래에서 온 경우 --> 하, 가능 반환
            return canGo(pipe, 1);
        } else if (dir == 1) { // 하, 위에서 온 경우 --> 상, 가능 반환
            return canGo(pipe, 0);
        } else if (dir == 2) { // 좌, 왼쪽에서 온 경우 --> 우, 가능
            return canGo(pipe, 3);
        } else if (dir == 3) { // 우, 오른쪽에서 온 경우 --> 좌, 가능
            return canGo(pipe, 2);
        }
        System.out.println("예외 발생");
        return true;
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
