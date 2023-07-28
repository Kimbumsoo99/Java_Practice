package baekjoon.implementations.gold.throw_dice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0}; // 동 서 북 남
    static int[] dy = {0, 0, -1, 1};
    static int[][] Graph;
    static int[] dice = new int[]{0, 0, 0, 0, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] start = new int[2];

        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());

        int L = Integer.parseInt(st.nextToken());

        Graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] next = start;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            next = game(cmd - 1, next);
        }
        System.out.println(sb);
    }

    static int[] game(int cmd, int[] currentDice) {
        int nextX = currentDice[1] + dx[cmd];
        int nextY = currentDice[0] + dy[cmd];

        // 지도 밖이면 명령 무시
        if (nextY < 0 || nextX < 0 || nextY >= Graph.length || nextX >= Graph[0].length) {
            return currentDice;
        }

        int tmp = 0;
        if(cmd == 0){
            tmp = east(Graph[nextY][nextX], new int[]{nextY, nextX});
        } else if (cmd == 1) {
            tmp = west(Graph[nextY][nextX], new int[]{nextY, nextX});
        } else if (cmd == 2) {
            tmp = north(Graph[nextY][nextX], new int[]{nextY, nextX});
        } else if (cmd == 3) {
            tmp = south(Graph[nextY][nextX], new int[]{nextY, nextX});
        }
        sb.append(tmp).append("\n");
        return new int[]{nextY, nextX};
    }

    static int east(int value, int[] current){
        int tmp1 = dice[0];
        int tmp2 = dice[3];
        int tmp3 = dice[5];
        int tmp4 = dice[2];

        dice[0] = tmp2;
        dice[2] = tmp1;
        dice[3] = tmp3;
        dice[5] = tmp4;

        setDice(value, current);
        return dice[0];
    }

    static int west(int value, int[] current){
        int tmp1 = dice[0];
        int tmp2 = dice[2];
        int tmp3 = dice[5];
        int tmp4 = dice[3];

        dice[0] = tmp2;
        dice[2] = tmp3;
        dice[3] = tmp1;
        dice[5] = tmp4;

        setDice(value, current);
        return dice[0];
    }

    static int south(int value, int[] current){
        int tmp1 = dice[0];
        int tmp2 = dice[4];
        int tmp3 = dice[5];
        int tmp4 = dice[1];

        dice[1] = tmp1;
        dice[0] = tmp2;
        dice[4] = tmp3;
        dice[5] = tmp4;

        setDice(value, current);
        return dice[0];
    }

    static int north(int value, int[] current){
        int tmp1 = dice[1];
        int tmp2 = dice[0];
        int tmp3 = dice[4];
        int tmp4 = dice[5];

        dice[0] = tmp1;
        dice[4] = tmp2;
        dice[5] = tmp3;
        dice[1] = tmp4;

        setDice(value, current);
        return dice[0];
    }

    static void setDice(int value, int[] current){
        if (value == 0) {
            Graph[current[0]][current[1]] = dice[5];
        } else {
            int tmp = Graph[current[0]][current[1]];
            Graph[current[0]][current[1]] = 0;
            dice[5] = tmp;
        }
    }
}
