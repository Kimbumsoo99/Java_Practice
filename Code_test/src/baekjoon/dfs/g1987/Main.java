package baekjoon.dfs.g1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static char[][] Graph;
    static int maxCount = 0;
    static int[] dx = new int[] { 0, 1, 0, -1 };
    static int[] dy = new int[] { 1, 0, -1, 0 };
    static HashSet<Character> set = new HashSet<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            Graph[i] = br.readLine().toCharArray();
        }
        set.add(Graph[0][0]);
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }

    static void dfs(int y, int x, int depth) {
        maxCount = Math.max(maxCount, depth);
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                if (!set.contains(Graph[nextY][nextX])) {
                    set.add(Graph[nextY][nextX]);
                    dfs(nextY, nextX, depth + 1);
                    set.remove(Graph[nextY][nextX]);
                }
            }
        }
    }
}
