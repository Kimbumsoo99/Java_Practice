package baekjoon.implementations.silver.s16926;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int[] dx = new int[] { 1, 0, -1, 0 }, dy = new int[] { 0, 1, 0, -1 };
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        int R = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//		for (int i = 0; i < R; i++) {
//
//		}
        int min = Math.min(N, M);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < min / 2; j++) {
                rotate(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(Graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotate(int idx) {
        int start = Graph[idx][idx];
//		int xCount = N - (idx * 2);
        int y = idx, x = idx;
        int dir = 0;
        int xCount = 0;
        int yCount = 0;
        boolean flag = true; // x는 true, y는 false
        while (true) {
            int nextY = y + dy[dir];
            int nextX = x + dx[dir];
            Graph[y][x] = Graph[nextY][nextX];
//			System.out.println("(" + y + ", " + x + ") <- (" + nextY + ", " + nextX + ")   " + dir);
            if (nextY == idx + 1 && nextX == idx)
                break;
            y = nextY;
            x = nextX;
            if (dir % 2 == 0)
                xCount++;
            else
                yCount++;
            if (flag && xCount != 0 && xCount % (M - (idx * 2) - 1) == 0) {
                dir++;
                flag = !flag;
//				System.out.println("ASDA");
                dir %= 4;
            } else if (!flag && yCount != 0 && yCount % (N - (idx * 2) - 1) == 0) {
                dir++;
                flag = !flag;
//				System.out.println("DSAD");
                dir %= 4;
            }
        }
        Graph[idx + 1][idx] = start;
    }
}
