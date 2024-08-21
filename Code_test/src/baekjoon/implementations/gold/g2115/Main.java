package baekjoon.implementations.gold.g2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R,C, Graph[][];
    static int[][] dx = {{1, 0, 1}, {1, 0, 1}, {0, -1, -1}, {0, 1, 1}}, dy = {{0, 1, 1}, {0, -1, -1}, {1, 0, 1}, {1, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] col = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                Graph[i][j] = "X".equals(col[j]) ? 1 : 0;
            }
        }

        int answer = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 벽이라면,
                if (Graph[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        boolean flag = false;
                        for (int l = 0; l < 3; l++) {
                            int nextY = i + dy[k][l];
                            int nextX = j + dx[k][l];

                            if (isMap(nextY, nextX)) {
                                // ㅡ ㅣ 위치 벽 조사
                                if (l == 0) {
                                    if (Graph[nextY][nextX] != 1) {
                                        flag = true;
                                        break;
                                    }
                                } else {
                                    if (Graph[nextY][nextX] == 1 || ((Graph[nextY][nextX] & (2 << k)) != 0)) {
                                        flag = true;
                                        break;
                                    }

                                }
                            }else{
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            answer++;
                            Graph[i + dy[k][1]][j + dx[k][1]] |= (2 << k);
                            Graph[i + dy[k][2]][j + dx[k][2]] |= (2 << k);
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
    
    static boolean isMap(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
