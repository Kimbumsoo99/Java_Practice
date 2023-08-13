package baekjoon.implementations.silver.s1051;
// 숫자 정사각형, 실버 III, 1051번

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxlength = 1;
    static int[][] rectangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        rectangle = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] A = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                rectangle[i][j] = Integer.parseInt(A[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    int current = rectangle[i][j];
                    if(current == rectangle[i][k]){
                        int tmp = k - j;
                        if (i + tmp >= N) {
                            continue;
                        }
                        if (current == rectangle[i + tmp][k] && current == rectangle[i + tmp][j]) {
                            maxlength = Math.max(maxlength, tmp + 1);
                        }
                    }
                }
            }
        }
        System.out.println(maxlength * maxlength);
    }

    static void draw(){
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
                System.out.print(rectangle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
