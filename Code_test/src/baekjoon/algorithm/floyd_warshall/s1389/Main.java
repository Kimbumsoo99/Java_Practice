package baekjoon.algorithm.floyd_warshall.s1389;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 케빈 베이컨의 6단계법칙, 실버 1
public class Main {
    static int[][] Graph;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new int[N][N];
        int dp[][] = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            Graph[A][B] = Graph[B][A] = 1;
            dp[A][B] = dp[B][A] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(Graph[i][j] == 0) {
                    Graph[i][j] = INF;
                    dp[i][j] = INF;
                }
            }
        }

        for (int current = 0; current < N; current++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i==j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][current] + dp[current][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int answer = -2;
        for (int i = 0; i < dp.length; i++) {
            int tmp = 0;
            for (int j = 0; j < dp.length; j++) {
                if(i == j) continue;
                tmp += dp[i][j];
            }
            if(min > tmp) {
                min = tmp;
                answer = i + 1;
            }
        }
        System.out.println(answer);
    }
}

