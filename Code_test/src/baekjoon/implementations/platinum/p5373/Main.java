package baekjoon.implementations.platinum.p5373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][][] initCube = { // 앞, 위, 왼, 뒤, 아, 우
            {{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'},},
            {{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'},},
            {{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'},},
            {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'},},
            {{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'},},
            {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'},},};
    static char[][][] cube;
    // 왼쪽 0 또는 오른쪽 1은 정방향 +1
    // 왼쪽 1 또는 오른쪽 0은 반대방향 -1
    static char[] lrTurn = { 'U', 'B', 'D', 'F' };
    // 위쪽 0 또는 오른쪽 1은 정방향 +1
    // 왼쪽 1 또는 오른쪽 0은 반대방향 -1
    static char[] udTurn = { 'F', 'R', 'B', 'L' };
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            cube = new char[6][3][3];
            init();
            for (int i = 0; i < N; i++) {
                String tmp = st.nextToken();
                char loc = tmp.charAt(0);
                char dir = tmp.charAt(1); // + 1, - 0
                rotate(loc, dir == '-' ? 0 : 1);
//                System.out.println(loc + " " + dir + " " + (i + 1) + "단계");
//                draw('U');
//                draw('F');
//                draw('L');
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(cube[mapping('U')][i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    static void draw(char c){
        System.out.println(c + " 방향");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(cube[mapping(c)][i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        sb = new StringBuilder();
    }

    static void init() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = initCube[i][j][k];
                }
            }
        }
    }

    static void rotate(char loc, int dir) {
        int lo = mapping(loc);
        twoDRotate(lo, dir);
        sideRotate(loc, dir);
    }

    static void sideRotate(char loc, int dir) {
        if (loc == 'F') {
            mappingTurnFront(dir);
        } else if (loc == 'B') {
            mappingTurnBack(dir);
        } else if(loc == 'U' || loc == 'D'){
            mappingTurnUpOrDown(loc, dir);
        }else{
            mappingTurnLeftOrRight(loc, dir);
        }
    }
    static void mappingTurnLeftOrRight(char loc, int dir) {
        int idx = 0;
        char dx[] = new char[]{'U', 'F', 'D', 'B'};
        if(loc == 'R') idx = 2;
        // Left 시계 or Right 반시계 U <- B 방향
        if ((loc == 'L' && dir == 1) || (loc == 'R' && dir == 0)) {
            dx = new char[]{'U', 'B', 'D', 'F'};
        }
        char[] tmp = new char[3];
        for (int i = 0; i < 3; i++) {
            tmp[i] = cube[mapping(dx[0])][i][idx];
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dx[i] == 'B') {
                    cube[mapping(dx[i])][2 - j][idx == 0 ? 2 : 0] = cube[mapping(dx[i + 1])][j][idx];
                } else if (dx[i + 1] == 'B') {
                    cube[mapping(dx[i])][j][idx] = cube[mapping(dx[i + 1])][2 - j][idx == 0 ? 2 : 0];
                } else {
                    cube[mapping(dx[i])][j][idx] = cube[mapping(dx[i + 1])][j][idx];
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            if (dx[3] == 'B') {
                cube[mapping(dx[3])][2 - j][idx == 0 ? 2 : 0] = tmp[j];
            } else {
                cube[mapping(dx[3])][j][idx] = tmp[j];
            }
        }
    }

    static void mappingTurnUpOrDown(char loc, int dir) {
        int idx = 0;
        char dx[] = new char[]{'F', 'L', 'B', 'R'};
        if (loc == 'D') idx = 2;
        // UP 시계 or DOWN 반시계 F <- R 방향
        if ((loc == 'U' && dir == 1) || (loc == 'D' && dir == 0)) {
            dx = new char[]{'F', 'R', 'B', 'L'};
        }
        char[] tmp = cube[mapping(dx[0])][idx];
        for (int i = 0; i < 3; i++) {
            cube[mapping(dx[i])][idx] = cube[mapping(dx[(i + 1) % 4])][idx];
        }
        cube[mapping(dx[3])][idx] = tmp;
    }

    static void mappingTurnFront(int dir) {
        char[] get = new char[3];
        for (int i = 0; i < 3; i++) {
            get[i] = cube[mapping('U')][2][i];
        }
        if (dir == 1) { // 시계 +
            for (int i = 0; i < 3; i++) {
                cube[mapping('U')][2][i] = cube[mapping('L')][2 - i][2];
                cube[mapping('L')][2 - i][2] = cube[mapping('D')][0][2 - i];
                cube[mapping('D')][0][2 - i] = cube[mapping('R')][i][0];
                cube[mapping('R')][i][0] = get[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                cube[mapping('U')][2][i] = cube[mapping('R')][i][0];
                cube[mapping('R')][i][0] = cube[mapping('D')][0][2 - i];
                cube[mapping('D')][0][2 - i] = cube[mapping('L')][2 - i][2];
                cube[mapping('L')][2 - i][2] = get[i];
            }
        }
    }

    static void mappingTurnBack(int dir) {
        char[] get = new char[3];
        for (int i = 0; i < 3; i++) {
            get[i] = cube[mapping('U')][0][i];
        }
        if (dir == 1) { // 시계 +
            for (int i = 0; i < 3; i++) {
                cube[mapping('U')][0][i] = cube[mapping('R')][i][2];
                cube[mapping('R')][i][2] = cube[mapping('D')][2][2 - i];
                cube[mapping('D')][2][2 - i] = cube[mapping('L')][2 - i][0];
                cube[mapping('L')][2 - i][0] = get[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                cube[mapping('U')][0][i] = cube[mapping('L')][2 - i][0];
                cube[mapping('L')][2 - i][0] = cube[mapping('D')][2][2 - i];
                cube[mapping('D')][2][2 - i] = cube[mapping('R')][i][2];
                cube[mapping('R')][i][2] = get[i];
            }
        }
    }

    static void twoDRotate(int lo, int dir) {
        char[][] turn = new char[3][3];
        if (dir == 1) {
            turnRight2d(turn, lo);
        } else {
            turnLeft2d(turn, lo);
        }
        cube[lo] = turn;
    }

    static void turnRight2d(char[][] tmp, int lo) {
        for (int i = 0; i < 3; i++) {
            tmp[0][i] = cube[lo][2 - i][0];
        }
        for (int i = 0; i < 3; i++) {
            tmp[2][i] = cube[lo][2 - i][2];
        }
        tmp[1][0] = cube[lo][2][1];
        tmp[1][1] = cube[lo][1][1];
        tmp[1][2] = cube[lo][0][1];
    }

    static void turnLeft2d(char[][] tmp, int lo) {
        for (int i = 0; i < 3; i++) {
            tmp[2][i] = cube[lo][i][0];
        }
        for (int i = 0; i < 3; i++) {
            tmp[0][i] = cube[lo][i][2];
        }
        tmp[1][0] = cube[lo][0][1];
        tmp[1][1] = cube[lo][1][1];
        tmp[1][2] = cube[lo][2][1];
    }

    /**
     *
     * @param loc 방향
     * @return 방향의 대한 cube 인덱스
     */
    static int mapping(char loc) {
        switch (loc) {
            case 'F': // 앞
                return 0;
            case 'U': // 위
                return 1;
            case 'L': // 왼
                return 2;
            case 'B': // 뒤
                return 3;
            case 'D': // 아
                return 4;
            default: // 오
                return 5;
        }
    }
}