package baekjoon.dfs.number_jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static HashSet<String> set = new HashSet<>();
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Graph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                Graph[i][j] = tmp;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, String.valueOf(Graph[i][j]));
            }
        }
//        Iterator<String> it = set.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
        System.out.println(set.size());
    }

    private static void dfs(int i, int j, int depth, String line) {
        // 재귀 종료
        if (depth == 6) {
            set.add(line);
            return;
        }

        // dfs
        for (int k = 0; k < 4; k++) {
            int nextY = i + dy[k];
            int nextX = j + dx[k];
            if (nextY >= 0 && nextX >= 0 && nextX < 5 && nextY < 5) {
                dfs(nextY, nextX, depth + 1, line + Graph[nextY][nextX]);
            }
        }
    }
}
