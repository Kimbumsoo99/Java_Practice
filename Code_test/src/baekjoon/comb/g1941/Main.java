package baekjoon.comb.g1941;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private final int[] dx = new int[]{0, 1, 0, -1};
    private final int[] dy = new int[]{1, 0, -1, 0};

    private int[][] Graph;
    private int[] index;
    private int answer;
    private boolean[] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        init();
        printResult(calcResult());
    }

    private int calcResult() {
        // 1. 조합을 뽑아서 7개의 인덱스 배열을 찾는다.
        // 2. 조합 내에 S 파가 총 4개라면, 연속된 위치인지 확인한다.
        // 3. 연속된 위치를 확인하는 방법은 bfs를 통해 총 7개가 됐는지 확인한다.
        comb(0, 0, 0);
        return answer;
    }

    private void comb(int cnt, int start, int daSom) {
        if (cnt - daSom > 3) return;

        if (cnt == 7) {
            visited = new boolean[7];
            if (bfs(index[0] / 5, index[0] % 5)) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i / 5;
            int col = i % 5;
            index[cnt] = i;
            comb(cnt + 1, i + 1, (Graph[row][col] == 2) ? daSom + 1 : daSom);
        }
    }

    private boolean bfs(int y, int x) {
        visited[0] = true;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x});
        int count = 1;
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX)) {
                    for (int j = 0; j < 7; j++) {
                        if (!visited[j] && index[j] == nextY * 5 + nextX) {
                            visited[j] = true;
                            count++;
                            dq.offer(new int[]{nextY, nextX});
                        }
                    }
                }
            }
        }
        return count == 7;
    }

    private boolean isMap(int y, int x) {
        return y >= 0 && y < 5 && x >= 0 && x < 5;
    }

    private void init() throws IOException {
        Graph = new int[5][5];
        index = new int[7];

        for (int i = 0; i < 5; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                Graph[i][j] = tmp[j] == 'S' ? 2 : 1;
            }
        }
    }

    public void printResult(int result) throws IOException {
        bw.write(result + "\n");
        bw.flush();
    }
}