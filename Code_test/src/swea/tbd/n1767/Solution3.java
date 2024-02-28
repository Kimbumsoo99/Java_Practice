package swea.tbd.n1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {
    static int N, Graph[][], cnt, answer, maxCore;
    static boolean[] visit;
    static ArrayList<int[]> coreList;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            sb.append("#" + test_case + " ");
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            cnt = 0;
            coreList = new ArrayList<>();
            Graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                    if (Graph[i][j] == 1) {
                        if (!(i == 0 || j == 0 || i == N - 1 || j == N - 1)) {
                            cnt++;
                            coreList.add(new int[]{i, j});
                        }
                    }
                }
            }
            visit = new boolean[cnt];
            System.out.println(cnt);
            for (int i = cnt; i >= 0; i--) {
                comb(0, 0, i);
                if(answer < Integer.MAX_VALUE) break;
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    static void comb(int depth, int idx, int end) {
        if (depth == end) {
            System.out.println(Arrays.toString(visit));
            simulation(0, 0);
            return;
        }
        for (int i = idx; i < cnt; i++) {
            visit[i] = true;
            comb(depth + 1, i + 1, end);
            visit[i] = false;
        }
    }

    static void simulation(int idx, int sum) {
        System.out.println(idx + " " + sum);
        if (idx == cnt) {
            answer = Math.min(answer, sum); // 배열 끝까지 돌렸으면 이때의 최솟값 갱신
            return;
        }
        if (!visit[idx]) {
            simulation(idx + 1, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[] core = coreList.get(idx);
            int nextY = core[0] + dy[i];
            int nextX = core[1] + dx[i];
            boolean flag = true;
            int lan = 0;
            while (isMap(nextY, nextX)) {
                if (Graph[nextY][nextX] != 0) {
                    flag = false;
                    break;
                }
                Graph[nextY][nextX] = 2;
                lan++;
                nextY += dy[i];
                nextX += dx[i];
            }
            if (flag) {
                simulation(idx + 1, sum + lan);
            }
            while (nextY != core[0] || nextX != core[1]) {
                nextY -= dy[i];
                nextX -= dx[i];
                Graph[nextY][nextX] = 0;
            }
        }
    }
//    static boolean[][] copyMap() {
//        boolean[][] copy = new boolean[N][N];
//        for (int i = 0; i < N; i++) {
//            copy[i] = visit[i].clone();
//        }
//        return copy;
//    }

    static boolean isMap(int y, int x) {
        return (y >= 0 && x >= 0 && y < N && x < N);
    }
}
