package baekjoon.implementations.platinum.p5373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][][] initCube = { // 앞, 위, 왼, 뒤, 아, 우
        { { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, { 'R', 'R', 'R' }, },
        { { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, { 'W', 'W', 'W' }, },
        { { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, { 'G', 'G', 'G' }, },
        { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, },
        { { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, { 'Y', 'Y', 'Y' }, },
        { { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, { 'B', 'B', 'B' }, }, };
    static char[][][] cube;
    // 왼쪽 0 또는 오른쪽 1은 정방향 +1
    // 왼쪽 1 또는 오른쪽 0은 반대방향 -1
    static char[] lrTurn = { 'U', 'B', 'D', 'F' };
    // 위쪽 0 또는 오른쪽 1은 정방향 +1
    // 왼쪽 1 또는 오른쪽 0은 반대방향 -1
    static char[] udTurn = { 'F', 'R', 'B', 'L' };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
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

    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    // 여기부터 다시 풀기
    static void sideRotate(char loc, int dir) {
        if (loc == 'F') {
            mappingTurnFront(dir);
        } else if (loc == 'B') {
            mappingTurnBack(dir);
        } else {

        }
    }

    static void mappingTurnFront(int dir) {
        char[] get = new char[3];
        for (int i = 0; i < 3; i++) {
            get[i] = cube[mapping('U')][0][i];
        }
        if (dir == 1) {
            for (int i = 0; i < 3; i++) {
                cube[mapping('U')][0][i] = cube[mapping('L')][2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                cube[mapping('L')][2 - i][2] = cube[mapping('D')][0][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                cube[mapping('D')][0][i] = cube[mapping('R')][i][0];
            }
            for (int i = 0; i < 3; i++) {
                cube[mapping('R')][i][0] = get[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                cube[mapping('U')][0][i] = cube[mapping('L')][2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                cube[mapping('L')][2 - i][2] = cube[mapping('D')][0][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                cube[mapping('D')][0][i] = cube[mapping('R')][i][0];
            }
            for (int i = 0; i < 3; i++) {
                cube[mapping('R')][i][0] = get[i];
            }
        }
    }

    static void mappingTurnBack(int dir) {

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