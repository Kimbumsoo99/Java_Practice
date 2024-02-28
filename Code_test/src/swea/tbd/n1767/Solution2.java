package swea.tbd.n1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {
    static int N, Graph[][], cnt, answer, maxCore;
    static boolean[][] visit;
    static boolean[] permVisit;
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
            System.out.println(cnt);
            visit = new boolean[N][N];
            permVisit = new boolean[N];

            perm(0, new int[cnt]);
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    static void perm(int depth, int[] arr) {
        if (depth == cnt) {
            solution(0, 0, 0, arr);
            return;
        }
        for (int i = 0; i < cnt; i++) {
            if (!permVisit[i]) {
                permVisit[i] = true;
                arr[depth] = i;
                perm(depth + 1, arr);
                permVisit[i] = false;
            }
        }
    }

    static void solution(int depth, int sum, int core, int[] arr) {
        if (depth == cnt) {
            System.out.println("core : " + core + " lan : " + sum);
            if (maxCore < core) {
                answer = sum;
            } else if (maxCore == core) {
                answer = Math.min(answer, sum);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int lan = cableSet(depth, i, arr);
            System.out.println("depth : " + depth + " dir : " + i + " lan : " + lan);
            if (lan != 0) {
                solution(depth + 1, sum + lan, core + 1, arr);
            }
        }
    }


//    static void simulation(int[] dir) {
//        int coreCount = 0;
//        int lan = 0;
//        for (int i = 0; i < cnt; i++) {
//            if(impossible[dir[i]][i]) continue;
//            int tmp = cableSet(i, dir[i]);
//            if (tmp != 0) {
//                coreCount++;
//            }
//            lan += tmp;
//        }
//        if (maxCore < coreCount) {
//            maxCore = coreCount;
//            answer = lan;
//        } else if (maxCore == coreCount) {
//            answer = Math.min(answer, lan);
//        }
////        System.out.println(maxCore + " " + answer);
//    }

    static int cableSet(int s, int d, int[] arr) {
        boolean[][] saveMap = copyMap();
        int[] core = coreList.get(arr[s]);
        int count = 0;
        int nextY = core[0] + dy[d];
        int nextX = core[1] + dx[d];
        while (isMap(nextY, nextX)) {
            count++;
            if (visit[nextY][nextX] || Graph[nextY][nextX] == 1) {
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
