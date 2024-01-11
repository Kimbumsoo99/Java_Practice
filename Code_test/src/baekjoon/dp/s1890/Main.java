package baekjoon.dp.s1890;
// 점프
import java.util.Scanner;

public class Main {
    static int[][] S;
    static long[][] dp;
    static int[] dy = new int[]{1, 0};
    static int[] dx = new int[]{0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        S = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (S[i][j] == 0) {
                    break;
                }
                for (int k = 0; k < 2; k++) {
                    int nextY = i + S[i][j] * dy[k];
                    int nextX = j + S[i][j] * dx[k];
                    if (nextY < N && nextX < N) {
                        dp[nextY][nextX] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    static void dfs(int y, int x) {
//		System.out.println(y +" " + x + " " + dp[y][x]);
        if (y == S.length - 1 && x == S.length - 1) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            int ny = y + S[y][x] * dy[i];
            int nx = x + S[y][x] * dx[i];
            if (ny < S.length && nx < S.length) {
                dp[ny][nx] += dp[y][x];
                dfs(ny, nx);
            }
        }

    }
}
