package baekjoon.simulation.g20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Fire{
        int y;
        int x;
        int mass;
        int speed;
        int direction;
        boolean dirNotFlag;
        int count;

        Fire(int mass, int speed, int direction, int y, int x) {
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
            this.y = y;
            this.x = x;
            count = 1;
        }

        @Override
        public String toString() {
            return String.valueOf(this.mass);
        }
    }

    static int N, M, K;
    static Fire Graph[][];
    static int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayDeque<Fire> fireBall = new ArrayDeque<>();
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 그래프 크기
        Graph = new Fire[N][N];
        visit = new boolean[N][N];
        M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
        K = Integer.parseInt(st.nextToken()); // 파이어볼 명령
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 파이어볼 위치
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            // 질량, 속력, 방향
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Graph[y][x] = new Fire(m, s, d, y, x);
            visit[y][x] = true;
            fireBall.add(Graph[y][x]);
        }

        for (int i = 0; i < K; i++) {
//            draw();
            if (fireBall.isEmpty()) {
                break;
            }
            magician();
//            System.out.println("===");
        }
//        draw();
        int answer = 0;
        while (!fireBall.isEmpty()) {
            answer += fireBall.pollFirst().mass;
        }
        System.out.println(answer);
    }
    static void draw(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((Graph[i][j] == null ? 0 : Graph[i][j].mass) + " ");
            }
            System.out.println();
        }
    }

    static void magician(){
        // 파이어볼 이동
        int loop = fireBall.size();
//        System.out.println(loop);
        for (int i = 0; i < loop; i++) {
            Fire tmp = fireBall.pollFirst();
            int nextY = tmp.y;
            int nextX = tmp.x;
            Graph[nextY][nextX] = null;
            visit[nextY][nextX] = false;
            nextY += dy[tmp.direction] * tmp.speed;
            nextX += dx[tmp.direction] * tmp.speed;
            if (nextY >= N) {
                nextY %= N;
            }
            if (nextX >= N) {
                nextX %= N;
            }
            if (nextY < 0) {
                nextY %= N;
                if (nextY != 0) {
                    nextY += N;
                }
            }
            if (nextX < 0) {
                nextX %= N;
                if (nextX != 0) {
                    nextX += N;
                }
            }
            tmp.y = nextY;
            tmp.x = nextX;
//            System.out.println(nextY + " " + nextX);

            fireBall.offer(tmp);
        }
//        for (int j = 0; j < N; j++) {
//            System.out.println(Arrays.toString(visit[j]));
//        }

        // 파이어볼 이동 후 합치기
        loop = fireBall.size();
        for (int i = 0; i < loop; i++) {
            Fire tmp = fireBall.pollFirst();
            int nextY = tmp.y;
            int nextX = tmp.x;
            if (visit[nextY][nextX]) {
                Graph[nextY][nextX].speed += tmp.speed;
                Graph[nextY][nextX].mass += tmp.mass;
                Graph[nextY][nextX].count += 1;
                if (Graph[nextY][nextX].direction % 2 != tmp.direction % 2) {
                    Graph[nextY][nextX].dirNotFlag = true;
                }
                continue;
            }
            visit[nextY][nextX] = true;
            Graph[nextY][nextX] = tmp;
            fireBall.offer(tmp);
        }


        loop = fireBall.size();
        // 모든 파이어볼 이동이 끝난 뒤, 파이어볼 분해
        for (int i = 0; i < loop; i++) {
            Fire tmp = fireBall.pollFirst();
            if (tmp.count > 1) {
                tmp.mass = tmp.mass / 5;
                tmp.speed = tmp.speed / tmp.count;
                if (tmp.mass == 0) {
                    Graph[tmp.y][tmp.x] = null;
                    visit[tmp.y][tmp.x] = false;
                    continue;
                }
                int dir = 0;
                if (tmp.dirNotFlag) {
                    dir = 1;
                }
                for (int j = dir; j < 8; j+=2) {
                    fireBall.offer(new Fire(tmp.mass, tmp.speed, j, tmp.y, tmp.x));
                }
            } else {
                fireBall.offer(tmp);
            }
        }
    }
    static boolean isMap(int y, int x){
        if (y >= 0 && x >= 0 && y < N && x < N) {
            return true;
        }
        return false;
    }
}
