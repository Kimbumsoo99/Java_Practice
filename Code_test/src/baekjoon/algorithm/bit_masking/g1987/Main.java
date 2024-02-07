package baekjoon.algorithm.bit_masking.g1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 사실 비트마스킹은 아님, bfs + 비트마스킹 풀이
public class Main {
    static int Graph[][];
    static int bin[][];
    static boolean[] visit = new boolean[26];
    static int N, M, answer = 0;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static final int BIN = (int) Math.pow(2, 26) - 1;
    static int mask = BIN;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = cArr[j] - 'A';
            }
        }
        bin = new int[N][M];
        bin[0][0] = (1 << Graph[0][0]); // 현재 위치 탐색 경우의 수
        visit[Graph[0][0]] = true; // 알파벳 저장
        System.out.println(dfs(0, 0));
    }

    static int dfs(int y, int x) {
        System.out.println((char) (Graph[y][x] + 'A'));
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (isMap(nextY, nextX)) {
                int next = Graph[nextY][nextX]; // 다음 위치 알파벳
                if (!visit[next]) { // 다음 알파벳은 첫 탐색인 경우
                    int route = (1 << (next)); // 다음 알파벳 비트
                    if (bin[nextY][nextX] != (bin[y][x] | route)) { // 다음 경로 탐색에 현재와 같은 알파벳 배열이 온 적이 없다면, (있다면 굳이니까)
                        bin[nextY][nextX] = bin[y][x] | route;
                        visit[next] = true;
                        int nextResult = dfs(nextY, nextX);
                        result = Math.max(result, nextResult);
                        visit[next] = false;
                    }
                }
            }
        }
        return result + 1;
    }
    static void bfs(int y, int x) {
        int mask = (int) Math.pow(2, 26) - 1;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x, 0});
        mask = mask - (1 << (Graph[y][x] - 'A'));
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            System.out.println(Integer.toBinaryString(mask));
            answer = Math.max(answer, tmp[2]);
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    if ((mask & (1 << (Graph[nextY][nextX] - 'A'))) != 0) {
                        mask = mask - (1 << (Graph[nextY][nextX] - 'A'));
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                    }
                }
            }
        }
    }
    static boolean isMap(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }
}
