package baekjoon.algorithm.floyd_warshall.s11403;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로 찾기, 실버 1
public class Main {
    static int[][] Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int current = 0; current < N; current++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Graph[i][j] == 1)
                        continue;
                    else {
                        if (Graph[i][current] == 1 && Graph[current][j] == 1) {
                            Graph[i][j] = 1;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(Graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

