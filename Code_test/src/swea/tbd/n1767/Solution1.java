package swea.tbd.n1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 중복 조합 완탐
public class Solution1 {
    static int N, Graph[][], cnt, answer, maxCore;
    static boolean[][] visit;
    static boolean[][] impossible;
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
            maxCore = 0;
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
            int dir[] = new int[cnt];
            impossible = new boolean[4][cnt];
            comb(0, dir);
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    static void comb(int depth, int[] dir) {
        if (depth == cnt) {
            simulation(dir);
            return;
        }
        for (int i = 0; i < 4; i++) {
            dir[depth] = i;
            comb(depth + 1, dir);
        }
    }


    static void simulation(int[] dir) {
        visit = new boolean[N][N];
        int coreCount = 0;
        int lan = 0;
        for (int i = 0; i < cnt; i++) {
            if(impossible[dir[i]][i]) continue;
            int tmp = cableSet(i, dir[i]);
            if (tmp != 0) {
                coreCount++;
            }
            lan += tmp;
        }
        if (maxCore < coreCount) {
            maxCore = coreCount;
            answer = lan;
        } else if (maxCore == coreCount) {
            answer = Math.min(answer, lan);
        }
//        System.out.println(maxCore + " " + answer);
    }

    static int cableSet(int s, int d) {
        boolean[][] saveMap = copyMap();
        int[] core = coreList.get(s);
        int count = 0;
        int nextY = core[0] + dy[d];
        int nextX = core[1] + dx[d];
        while (isMap(nextY, nextX)) {
            count++;
            if (visit[nextY][nextX]) {
                visit = saveMap;
                return 0;
            } else if (Graph[nextY][nextX] == 1) {
                impossible[d][s] = true; // 불가능
                visit = saveMap;
                return 0;
            } else {
                visit[nextY][nextX] = true;
                nextY += dy[d];
                nextX += dx[d];
            }
        }
        return count;
    }

    static boolean[][] copyMap() {
        boolean[][] copy = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = visit[i].clone();
        }
        return copy;
    }

    static boolean isMap(int y, int x) {
        return (y >= 0 && x >= 0 && y < N && x < N);
    }
}
