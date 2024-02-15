package swea.d3.n1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, Graph[][], dir;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1}; // 우 아 왼 위
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T+1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dir = 0;
            Graph = new int[N][M];
            dq = new ArrayDeque<>();
            int start[] = new int[2];
            for (int i = 0; i < N; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    int c = -1;
                    // . 평지 0
                    if(tmp[j] == '.'){ // 평지
                        c = 0;
                    }else if(tmp[j] == '*') { // 돌 벽
                        c = 2;
                    }else if(tmp[j] == '#') { // 강철 벽
                        c = 3;
                    }else if(tmp[j] == '-'){// 물
                        c = 1;
                    }else if(tmp[j] == '^'){
                        c = 13;
                    } else if (tmp[j] == 'v') {
                        c = 11;
                    } else if (tmp[j] == '<') {
                        c = 12;
                    } else {
                        c = 10;
                    }
                    Graph[i][j] = c;
                    if (c >= 10) {
                        start = new int[]{i, j};
                        dir = c - 10;
                    }
                }
            }
            int L = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < L; i++) {
                char tmp = str.charAt(i);
                if(tmp == 'U') dq.offer(3);
                else if(tmp=='D')dq.offer(1);
                else if(tmp=='L') dq.offer(2);
                else if (tmp == 'R') {
                    dq.offer(0);
                } else {
                    dq.offer(4);
                }
            }

            tank(start);
            sb.append("#" + test_case + " ");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(intToCharMapping(Graph[i][j]));
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void tank(int[] start) {
        int[] current = start;
//        System.out.println(dir + " " + Graph[start[0]][start[1]]);
        while (!dq.isEmpty()) {
            int op = dq.pollFirst();
            if (op == 4) { // 폭탄 쏘기
                int nextY = current[0] + dy[dir];
                int nextX = current[1] + dx[dir];

                // 폭탄이 맵 안
                while (isMap(nextY, nextX)) {
//                    System.out.println(Graph[nextY][nextX] + " " + intToCharMapping(Graph[nextY][nextX]));
                    // 평지 또는 물
                    if (Graph[nextY][nextX] < 2) {
                        nextY += dy[dir];
                        nextX += dx[dir];
                    }else{ // 벽이라면
                        if (Graph[nextY][nextX] == 2) { // 돌 벽
                            Graph[nextY][nextX] = 0;
                        }
                        break; // 벽이라면 포탄은 멈춤
                    }
                }
            } else {
                // 방향 전환
                dir = op;
                Graph[current[0]][current[1]] = dir + 10;
                int nextY = current[0] + dy[dir];
                int nextX = current[1] + dx[dir];
                if (!isMap(nextY, nextX)) {
                    continue;
                }
                // 이동
//                System.out.println(Graph[nextY][nextX] + " " + intToCharMapping(Graph[nextY][nextX]));
                if (Graph[nextY][nextX] == 0) {
                    Graph[current[0]][current[1]] = 0;
                    Graph[nextY][nextX] = dir + 10;
                    current = new int[]{nextY, nextX};
                }
            }
        }
    }
    
    
    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }

    static char intToCharMapping(int op) {
        switch (op) {
            case 0:
                return '.';
            case 1:
                return '-';
            case 2:
                return '*';
            case 3:
                return '#';
            case 10:
                return '>';
            case 11:
                return 'v';
            case 12:
                return '<';
            default:
                return '^';
        }
    }
}
