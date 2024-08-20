package baekjoon.graph.bfs.g6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C, Graph[][][], start[];
    static int[] dx = new int[]{0, 1, 0, -1, 0, 0}, dy = new int[]{1,0,-1,0,0,0}, dz = new int[]{0, 0, 0, 0, 1, -1};
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (((L | R) | C) == 0) {
                break;
            }

            Graph = new int[L][R][C];
            visit = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String[] tmp = br.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        if ("S".equals(tmp[k])) {
                            start = new int[]{i, j, k};
                            Graph[i][j][k] = 1;
                            visit[i][j][k] = true;
                        } else if ("E".equals(tmp[k])) {
                            Graph[i][j][k] = 3;
                        } else if ("#".equals(tmp[k])) {
                            Graph[i][j][k] = 2;
                        }
                    }
                }
            }


            int time = bfs();
            if (time == -1) {
                sb.append("Trapped!\n");
            }else{
                sb.append("Escaped in " + time + " minute(s).\n");
            }
        }
        System.out.println(sb);
    }

    static int bfs(){
        int time = 0;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);

        return time;
    }

    public static boolean isMap(int z, int y, int x){
        return y >= 0 && y < R && x >= 0 && x < C && z >= 0 && z < L;
    }
}
