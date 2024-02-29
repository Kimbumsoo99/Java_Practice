package swea.tbd.n1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st = null;
    private StringBuilder sb = new StringBuilder();

    private int N, K, Graph[][], answer = 0;
    private int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    private boolean[][] visit;

    public static void main(String[] args) {
        new Solution().solution();
    }

    private void solution() {
        try {
            int T = Integer.parseInt(br.readLine());
            for (int test_case = 1; test_case < T + 1; test_case++) {
                init();
                sb.append("#" + test_case + " " + answer + "\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
        }
    }

    private void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int max = 0;
        answer = 0;
        visit = new boolean[N][N];
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if (max < Graph[i][j])
                    max = Graph[i][j];
            }
        }

        ArrayList<int[]> startList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Graph[i][j] == max) {
                    startList.add(new int[] { i, j });
                }
            }
        }

        for (int[] top : startList) {
            dfs(top, 1, 1);
        }
    }

    private void dfs(int[] current, int chance, int route) {
        answer = Math.max(answer, route);
        int curVal = Graph[current[0]][current[1]];
        visit[current[0]][current[1]] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = current[0] + dy[i];
            int nextX = current[1] + dx[i];
            if (!isMap(nextY, nextX) || visit[nextY][nextX])
                continue;
            if (Graph[nextY][nextX] < curVal) {
                dfs(new int[] { nextY, nextX }, chance, route + 1);
            } else if (chance == 1 && Graph[nextY][nextX] - K < curVal) {
                int save = Graph[nextY][nextX];
                Graph[nextY][nextX] = curVal - 1;
                dfs(new int[] { nextY, nextX }, chance - 1, route + 1);
                Graph[nextY][nextX] = save;
            }
        }
        visit[current[0]][current[1]] = false;
    }

    private boolean isMap(int y, int x) {
        return (y >= 0 && x >= 0 && y < N && x < N);
    }
}
