package baekjoon.implementations.silver.switch_on;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] switchBtn;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int row = N / 20;
        int col = N % 20;
        switchBtn = new int[row][col];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            switchBtn[i / 20][i % 20] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            if (sex == 1) {
                // 남자
                manSolution(location);
            }else {

            }
        }
    }
    static void manSolution(int l){
        int idx = l;
        for (int i = 1; idx < N; i++) {
            switchBtn[idx / 20][idx % 20] = switchBtn[idx / 20][idx % 20] == 0 ? 1 : 0;
            idx = l * i;
        }

    }
    static void womenSolution(int l){

    }
}
