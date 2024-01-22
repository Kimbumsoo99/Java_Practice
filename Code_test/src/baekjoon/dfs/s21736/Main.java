package baekjoon.dfs.s21736;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 헌내기는 친구가 필요해, 실버 2
public class Main {
    static char[][] Graph;
    static boolean[][] visit;
    static int[] dx = new int[] { 1, 0, -1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new char[N][M];
        visit = new boolean[N][M];
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (tmp.charAt(j) == 'I') {
                    Graph[i][j] = tmp.charAt(j);
                    start = new int[] { i, j };
                    visit[i][j] = true;
                } else {
                    Graph[i][j] = tmp.charAt(j);
                }
            }
        }
        int answer = bfs(start);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    static int bfs(int[] start) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int count = 0;
        dq.offer(start);
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph[0].length) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] != 'X') {
                        dq.offer(new int[] { nextY, nextX });
                        visit[nextY][nextX] = true;
                        if (Graph[nextY][nextX] == 'P') {
                            count++;
                        }
                    }
                }

            }
        }
        return count;
    }
}

