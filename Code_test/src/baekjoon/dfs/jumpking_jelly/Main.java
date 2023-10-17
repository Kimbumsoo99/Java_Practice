package baekjoon.dfs.jumpking_jelly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        visit = new boolean[N][N];
        // (0,0) 출발, 구역 외부로 나가면 게임 종료, 오른쪽 아래 방향만 이동 가능, (N-1,N-1) 게임 승리
        // Graph[i][j] 만큼 이동
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean answer = dfs();
        if (answer) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static boolean dfs() {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!stack.isEmpty()) {
            int[] tmp = stack.pop();
            int move = Graph[tmp[0]][tmp[1]];
            for (int i = 0; i < 2; i++) {
                int nextX = tmp[1] + (dx[i] * move);
                int nextY = tmp[0] + (dy[i] * move);
                if (nextX < Graph.length && nextY < Graph.length && !visit[nextY][nextX]) {
                    stack.push(new int[]{nextY, nextX});
                    visit[nextY][nextX] = true;
                    if (Graph[nextY][nextX] == -1) {
                        stack.clear();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
