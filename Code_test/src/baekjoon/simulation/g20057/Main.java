package baekjoon.simulation.g20057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static boolean[][] visit;
    static int N;
    static int answer = 0;
    static int[][][] dirTornadoMap = new int[4][5][5];
    static int[][] tornadoMap = {
        {0, 0, 2, 0, 0},
        {0, 10, 7, 1, 0},
        {5, 3, 0, 0, 0},
        {0, 10, 7, 1, 0},
        {0, 0, 2, 0, 0}
    };
    static int dx[] = new int[]{-1, 0, 1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        visit = new boolean[N][N];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 4; i++) {
            dirTornadoMap[i] = tornadoMap;
            turnTornadoMap();
        }

        tornado();
        System.out.println(answer);
    }

    static void tornado(){
        int direction = 0; // 왼, 하, 우, 상
        int y, x;
        y = x = N / 2;
        visit[y][x] = true;
        while (y != 0 || x != 0) {
            int nextY = y + dy[direction];
            int nextX = x + dx[direction];
            if (isMap(nextY, nextX) && !visit[nextY][nextX]) {
                visit[nextY][nextX] = true;
                wind(y, x, nextY, nextX, direction);
                turnTornadoMap();
//                draw();
                y = nextY;
                x = nextX;
                direction++;
                if (direction == 4) {
                    direction = 0;
                }
            } else {
                direction -= 1;
                if (direction == -1) {
                    direction = 3;
                }
            }
        }
    }
    public static void turnTornadoMap() {
        int[][] newTornadoMap = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                newTornadoMap[4-j][i] = tornadoMap[i][j];
            }
        }
        tornadoMap = newTornadoMap;
    }

    static void draw(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void wind(int preY, int preX, int nextY, int nextX, int dir) {
        int dirP = dir + 1 == 4 ? 0 : (dir + 1);
        int dirM = dir - 1 == -1 ? 3 : (dir - 1);
        int dirArr[] = new int[]{dirP, dirM};
        int sand = Graph[nextY][nextX];
        int per5 = sand * 5 / 100;
        int per10 = sand * 10 / 100;
        int per7 = sand * 7 / 100;
        int per2 = sand * 2 / 100;
        int per1 = sand / 100;
        sand -= (per5 + (2 * per10) + (2 * per7) + (2 * per2) + (2 * per1));
        int[] addPerMap = new int[]{0, per1, per2, sand, 0, per5, 0, per7, 0, 0, per10};

        int startR = nextY - 2;
        int startC = nextX - 2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                int nr = startR + i ;
                int nc = startC + j ;
                int add = addPerMap[dirTornadoMap[dir][i][j]];
                if (isMap(nr, nc)) {
                    Graph[nr][nc] += add;
                } else {
                    answer += add;
                }
            }
        }
        Graph[nextY][nextX] = 0;
    }


    static boolean isMap(int y, int x){
        if (y >= 0 && x >= 0 && y < N && x < N) {
            return true;
        }
        return false;
    }
}
