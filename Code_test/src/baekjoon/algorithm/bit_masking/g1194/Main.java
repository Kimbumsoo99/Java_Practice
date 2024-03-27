package baekjoon.algorithm.bit_masking.g1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Person {
    int y;
    int x;
    int keyFlag;
    int count;

    @Override
    public String toString() {
        return "Person [y=" + y + ", x=" + x + ", keyFlag=" + keyFlag + ", count=" + count + "]";
    }

    public Person(int y, int x, int keyFlag, int count) {
        super();
        this.y = y;
        this.x = x;
        this.keyFlag = keyFlag;
        this.count = count;
    }

}

public class Main {
    static char[][] Graph;
    static int start[], N, M;
    static int[] dx = { 1, 0, 0, -1 }, dy = { 0, 1, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            Graph[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (Graph[i][j] == '0') {
                    start = new int[] { i, j };
                }
            }
        }
        System.out.println(bfs(start));
    }

    static int bfs(int[] start) {
        PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count) {
                return o2.keyFlag - o1.keyFlag;
            }
            return o1.count - o2.count;
        });
        pq.offer(new Person(start[0], start[1], 1, 0));
        boolean[][][] visit = new boolean[(1 << 7)][N][M];
        visit[0][start[0]][start[1]] = true;
        while (!pq.isEmpty()) {
            Person now = pq.poll();
//			System.out.println(now);
            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                if (isMap(nextY, nextX) && Graph[nextY][nextX] != '#') {

                    if (!visit[now.keyFlag][nextY][nextX]) {
//						System.out.println("들림 " + Graph[nextY][nextX]);
                        if (Graph[nextY][nextX] == '.' || Graph[nextY][nextX] == '0') {
                            pq.offer(new Person(nextY, nextX, now.keyFlag, now.count + 1));
                            visit[now.keyFlag][nextY][nextX] = true;
                        } else if (Graph[nextY][nextX] >= 'A' && Graph[nextY][nextX] < 'G') {
                            int flag = (1 << (Graph[nextY][nextX] - 'A' + 1));
//							System.out.println(now.keyFlag + " " + flag + " " + (now.keyFlag & flag));
                            if ((now.keyFlag & flag) != 0) {
                                pq.offer(new Person(nextY, nextX, now.keyFlag, now.count + 1));
                                visit[now.keyFlag][nextY][nextX] = true;
                            }
                        } else if (Graph[nextY][nextX] == '1') {
//							System.out.println("아래 " + Graph[nextY][nextX]);
                            return now.count + 1;
                        } else {
                            pq.offer(new Person(nextY, nextX, now.keyFlag | (1 << (Graph[nextY][nextX] - 'a' + 1)),
                                now.count + 1));
                            visit[now.keyFlag][nextY][nextX] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}

