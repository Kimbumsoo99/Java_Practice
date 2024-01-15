package swea.ssafy.n2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = new int[] {-1,0,1,-1,1,-1,0,1};
    static int[] dy = new int[] {-1,-1,-1,0,0,1,1,1};
    static int[] dy2 = new int[] {1,0,-1,0};
    static int[] dx2 = new int[] {0,1,0,-1};
    static int[][] Graph;
    static char[][] bg;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            Graph = new int[N][N];
            bg = new char[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    String tmp = st.nextToken();
                    if(tmp.equals("B")) bg[i][j] = 'B';
                    else bg[i][j] = 'G';
                }
            }

            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(bg[i][j] == 'B') {
                        int height = getHeight(i, j, N);
                        if(height > maxHeight) maxHeight = height;
                    }
                }
            }
            System.out.println("#"+test_case+" "+ maxHeight);
        }
    }

    static int getHeight(int y, int x, int N) {
        for (int i = 0; i < 7; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY >= 0 &&nextX >=0 && nextY <N&&nextX <N) {
                if(bg[nextY][nextX] == 'G') return 2;
            }
        }

        return cross(y, x, N);
    }

    static int cross(int y, int x, int N) {
        int sum = 1;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy2[i];
            int nextX = x + dx2[i];
            while(nextY>= 0 && nextX >= 0 &&nextY <= N-1&&nextX <=N-1) {
                if(bg[nextY][nextX] == 'B') sum++;
                nextY += dy2[i];
                nextX += dx2[i];
            }
        }
        return sum;
    }
}