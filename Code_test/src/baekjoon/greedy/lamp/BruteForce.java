package baekjoon.greedy.lamp;

import java.io.*;
import java.util.*;

public class BruteForce {

    static int N;
    static int M;

    static int K;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        if (K > M) {
            if (K % 2 == 0 && M % 2 == 0) {
                K = M;
            } else if (K % 2 == 0 && M % 2 == 1) {
                K = M + 1;
            } else if (K % 2 == 1 && M % 2 == 0) {
                K = M + 1;
            } else if (K % 2 == 1 && M % 2 == 1) {
                K = M;
            }
        }

        recur(0, map);
        System.out.println(max);

    }

    public static void recur(int count, int[][] map) {
        if (count == K) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = false;
                for (int j = 0; j < M; j++) {
                    if (map[i][0] == 1) {
                        if (map[i][j] == 0) {
                            flag = true;
                            break;
                        }
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    cnt++;
                }
            }
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            max = Math.max(max, cnt);

            return;
        }
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (map[k][j] == 1) {
                    map[k][j] = 0;
                } else {
                    map[k][j] = 1;
                }
            }
            recur(count + 1, map);
            for (int k = 0; k < N; k++) {
                if (map[k][j] == 1) {
                    map[k][j] = 0;
                } else {
                    map[k][j] = 1;
                }
            }
        }


    }
}
