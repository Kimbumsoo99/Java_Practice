package baekjoon.algorithm.divide_and_conquer.s2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    static void recur(int y, int x, int size){
        // 검사 로직
        int choice = Graph[y][x];
        boolean flag = true;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(choice != Graph[i][j]){
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        // 정답인 경우 종료
        if(flag){
            if (choice == 1) {
                blue++;
            } else {
                white++;
            }
        }
        // 정답이 아닌 경우 분할해서 다시 입력
        else{
            recur(y, x, size / 2);
            recur(y + size / 2, x, size / 2);
            recur(y, x + size / 2, size / 2);
            recur(y + size / 2, x + size / 2, size / 2);
        }
    }
}
