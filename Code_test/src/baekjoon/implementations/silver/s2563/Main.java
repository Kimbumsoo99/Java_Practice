package baekjoon.implementations.silver.s2563;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxR = 0, maxC = 0, minR = 101, minC = 101;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        visit = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            minR = Math.min(minR, r);
            minC = Math.min(minC, c);
            maxR = Math.max(maxR, r);
            maxC = Math.max(maxC, c);
            for (int j = r; j < r + 10; j++) {
                for (int k = c; k < c + 10; k++) {
                    visit[j][k] = true;
                }
            }
        }
        int sum = 0;
        for (int i = minR; i < maxR + 10; i++) {
            for (int j = minC; j < maxC + 10; j++) {
                if (visit[i][j])
                    sum++;
            }
        }
        System.out.println(sum);
    }
}
