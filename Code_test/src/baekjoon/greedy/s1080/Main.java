package baekjoon.greedy.s1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] S;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        S = new int[N][M];
        answer = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                S[i][j] = tmp.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                answer[i][j] = tmp.charAt(j) - '0';
            }
        }

        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if(S[i][j] != answer[i][j]){
                    count++;
                    reverse(i, j);
                }
            }
        }

        boolean flag = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(S[i][j] != answer[i][j]){
                    flag = false;
                }
            }

        }
        if (!flag) {
            System.out.println(-1);
        }else {
            System.out.println(count);
        }
    }

    private static void reverse(int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                S[i][j] = S[i][j] == 0 ? 1 : 0;
            }
        }
    }

}
