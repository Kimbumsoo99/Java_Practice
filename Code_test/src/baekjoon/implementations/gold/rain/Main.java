package baekjoon.implementations.gold.rain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] Graph;
    static boolean lastWall = true; // 마지막이 벽이었다면 true
    static boolean rain = false; // 빗물을 센다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < tmp; j++) {
                Graph[j][i] = 1;
            }
        }
//        draw();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int water = 0;
            for (int j = 0; j < M; j++) {
                if (lastWall && j != 0 && Graph[i][j] == 0) {
                    rain = true;
                }
                else if (!lastWall && Graph[i][j] == 1) {
//                    System.out.println(water + " 추가!");
                    answer += water;
                    water = 0;
                    rain = false;
                }

                if (rain) {
//                    System.out.println(i + " " + j);
                    water++;
                }

                if (Graph[i][j] == 1) {
                    lastWall = true;
                }else{
                    lastWall = false;
                }
            }
            rain = false;
            lastWall = true;
        }
        System.out.println(answer);
    }

    static void draw(){
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph[0].length; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
