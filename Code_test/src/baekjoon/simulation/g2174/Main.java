package baekjoon.simulation.g2174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int X, Y;
    static int[][] Graph;
    static ArrayList<int[]> robot = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()); // 가로
        Y = Integer.parseInt(st.nextToken()); // 세로
        Graph = new int[Y + 1][X + 1]; // 0 땅, 1 로봇
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 로봇 위치 x,y ,방향
            int rX = Integer.parseInt(st.nextToken());
            int rY = Integer.parseInt(st.nextToken());
            int rD = getDirection(st.nextToken().charAt(0));
            robot.add(new int[]{rY, rX, rD});
            Graph[rY][rX] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 로봇 위치 x,y ,방향
            int rIdx = Integer.parseInt(st.nextToken()) - 1;
            char op = st.nextToken().charAt(0);
            int loop = Integer.parseInt(st.nextToken());;
            cmd(rIdx, op, loop);
        }
        System.out.println("OK");
    }

    static void cmd(int rIdx, char op, int loop) {
        switch (op) {
            case 'L':
                loop %= 4;
                for (int i = 0; i < loop; i++) {
                    robot.get(rIdx)[2] -= 1;
                    if (robot.get(rIdx)[2] == -1) {
                        robot.get(rIdx)[2] = 3;
                    }
                }
                break;
            case 'R':
                loop %= 4;
                for (int i = 0; i < loop; i++) {
                    robot.get(rIdx)[2] += 1;
                    if (robot.get(rIdx)[2] == 4) {
                        robot.get(rIdx)[2] = 0;
                    }
                }
                break;
            default: // F, 이동
                int nextY = robot.get(rIdx)[0];
                int nextX = robot.get(rIdx)[1];
                Graph[nextY][nextX] = 0;
                int direction = robot.get(rIdx)[2];
                for (int i = 0; i < loop; i++) {
                    nextY += dy[direction];
                    nextX += dx[direction];
//                    System.out.println(nextY + " " + nextX);
                    if (isMap(nextY, nextX)) {
                        if (Graph[nextY][nextX] == 1) {
                            int find = -1;
                            for (int j = 0; j < robot.size(); j++) {
                                if (robot.get(j)[0] == nextY && robot.get(j)[1] == nextX) {
                                    find = j + 1;
                                }
                            }
                            System.out.println("Robot " + (rIdx + 1) + " crashes into robot " + find);
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Robot " + (rIdx + 1) + " crashes into the wall");
                        System.exit(0);
                    }
                }
                robot.get(rIdx)[0] = nextY;
                robot.get(rIdx)[1] = nextX;
                Graph[nextY][nextX] = 1;
                break;
        }
    }
    static boolean isMap(int y, int x){
        if (y >= 1 && x >= 1 && y <= Y && x <= X) {
            return true;
        }
        return false;
    }

    static int getDirection(char D){
        switch (D) {
            case 'N':
                return 0;
            case 'E':
                return 1;
            case 'S':
                return 2;
            default: // W
                return 3;
        }
    }
}
