package baekjoon.implementations.gold.sawtooth_wheel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visit = new boolean[4];
    static int[] dx = {-1, 1};
    static int[] dxPole = {6, 2};
    static char[][] wheelList = new char[4][8];
    static void drawWheel(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(wheelList[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String tmp = br.readLine();
            int idx = 0;
            for (char w : tmp.toCharArray()) {
                wheelList[i][idx++] = w;
            }
        }
//        drawWheel();
        int cmd = Integer.parseInt(br.readLine());
//        System.out.println(cmd);
        StringTokenizer st;
        for (int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
//            System.out.println(wheelNum + " " + direction);
            visit = new boolean[4];
            rotation(wheelNum - 1, direction);
        }

        int answer = 0;
//        drawWheel();
        for (int i = 0; i < wheelList.length; i++) {
            if(wheelList[i][0] == '1') {
                int tmp = 1 << i;
                answer += tmp;
            }
        }
        System.out.println(answer);
    }

    static void rotation(int start, int d){
        visit[start] = true;
        for (int i = 0; i < 2; i++) {
            int nextX = start + dx[i];
            char tmp = wheelList[start][dxPole[i]];
            if (nextX >= 0 && nextX < 4) {
                if (!visit[nextX] && wheelList[nextX][dxPole[(i + 1) % 2]] != tmp) {
                    rotation(nextX, -d);
                }
            }
        }
        if (d == -1) {
            rear(start);
        } else {
            forward(start);
        }

    }

    // 1 2 3 4 5 6 7 8
    // 2 3 4 5 6 7 8 1
    static void rear(int wheel){ // 반시계방향 <-
        char last = wheelList[wheel][0];
        for (int i = 1; i < 8; i++) {
            wheelList[wheel][i-1] = wheelList[wheel][i];
        }
        wheelList[wheel][7] = last;
    }

    // 1 2 3 4 5 6 7 8
    // 8 1 2 3 4 5 6 7
    static void forward(int wheel){ // 시계방향 ->
        char first = wheelList[wheel][7];
        for (int i = 6; i >= 0; i--) {
            wheelList[wheel][i+1] = wheelList[wheel][i];
        }
        wheelList[wheel][0] = first;
    }

}
