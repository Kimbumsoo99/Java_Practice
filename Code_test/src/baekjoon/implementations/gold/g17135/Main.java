package baekjoon.implementations.gold.g17135;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D, Graph[][], answer = 0;
    static int[] dx = { -1, 0, 1 }, dy = { 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        Graph = new int[N + 1][M];
        D = Integer.parseInt(st.nextToken()); // 사거리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        int[][] init = new int[N + 1][M];
        for (int i = 0; i < N + 1; i++) {
            init[i] = Graph[i].clone();
        }
        int[] comb = new int[M];
        comb[M - 1] = comb[M - 2] = comb[M - 3] = 1;
        do {
//			System.out.println(Arrays.toString(comb));
            int count = 0;
            for (int i = 0; i < N; i++) {
//				draw();
                count += shoot(comb);
            }
            answer = Math.max(answer, count);
            for (int i = 0; i < N + 1; i++) {
                Graph[i] = init[i].clone();
            }
        } while (np(comb));
        System.out.println(answer);
    }

    static void draw() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int shoot(int[] comb) {
        int count = 0;

        ArrayList<int[]> kill = new ArrayList<>();
        int idx = 0;

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            if (comb[i] == 1) {
                boolean[][] visit = new boolean[N][M];
                deque.offer(new int[] { N - 1, i, 1 });
                visit[N - 1][i] = true;
                while (!deque.isEmpty()) {
                    int[] tmp = deque.pollFirst();
                    if (tmp[2] > D) {
                        deque.clear();
                        break;
                    } else if (Graph[tmp[0]][tmp[1]] == 1) {
                        kill.add(tmp);
                        deque.clear();
                        break;
                    }

                    for (int j = 0; j < 3; j++) {
                        int nextY = tmp[0] + dy[j];
                        int nextX = tmp[1] + dx[j];
                        if (isMap(nextY, nextX) && !visit[nextY][nextX]) {
                            visit[nextY][nextX] = true;
                            deque.offer(new int[] { nextY, nextX, tmp[2] + 1 });
                        }
                    }
                }
            }
        }
        for (int[] k : kill) {
            if (Graph[k[0]][k[1]] != 0) {
                count++;
                Graph[k[0]][k[1]] = 0;
            }
        }

        for (int i = N - 1; i > 0; i--) {
            Graph[i] = Graph[i - 1];
        }
        Graph[0] = new int[M];
        return count;
    }

    static boolean np(int[] p) {
        int i = M - 1;
        while (i > 0 && p[i - 1] >= p[i])
            --i;
        if (i == 0)
            return false;

        int j = M - 1;
        while (p[i - 1] >= p[j])
            --j;

        swap(p, i - 1, j);
        int k = M - 1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }
}
