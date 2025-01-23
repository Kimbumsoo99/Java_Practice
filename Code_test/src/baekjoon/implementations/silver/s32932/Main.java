package baekjoon.implementations.silver.s32932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{0, 0, -1, 1}, dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Coordinate> pitFall = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pitFall.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Coordinate cur = new Coordinate(0, 0);
        char[] commands = br.readLine().toCharArray();
        for (int i = 0; i < K; i++) {
            int ny = cur.y + dy[cmd(commands[i])];
            int nx = cur.x + dx[cmd(commands[i])];
            if (!pitFall.contains(new Coordinate(nx, ny))) {
                cur.y = ny;
                cur.x = nx;
            }
        }
        System.out.println(cur.x + " " + cur.y);
    }

    static int cmd(char c) {
        switch (c) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            default:
                return 3;
        }
    }

    static class Coordinate {
        int y, x;

        public Coordinate(int x, int y) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            return y == that.y && x == that.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}