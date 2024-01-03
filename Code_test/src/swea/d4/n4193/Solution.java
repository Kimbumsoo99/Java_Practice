package swea.d4.n4193;
import java.util.*;

class Solution {

    static int[][] Graph;
    static boolean visit[][];
    static boolean wind[][];
    static ArrayList<int[]> windList;
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt();
                Graph = new int[N][N];
                wind = new boolean[N][N];
                visit = new boolean[N][N];
                windList = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        int tmp = sc.nextInt();
                        if (tmp == 2) {
                            wind[i][j] = true;
                            windList.add(new int[]{i, j});
                        }
                        Graph[i][j] = tmp;
                    }
                }
                int[] start = new int[]{sc.nextInt(), sc.nextInt()};
                int[] finish = new int[]{sc.nextInt(), sc.nextInt()};

                int answer = bfs(start, finish, N);
                System.out.println("#" + test_case + " " + answer);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int bfs(int start[], int[] finish, int N) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start[0], start[1], 0});
        visit[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
            // System.out.println(tmp[0]+" "+tmp[1]+" "+tmp[2]);
            if (tmp[0] == finish[0] && tmp[1] == finish[1]) {
                return tmp[2];
            }
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] == 2) { // 허리케인인 경우
                        if (tmp[2] % 3 == 2) {
                            visit[nextY][nextX] = true;
                            dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        } else {
                            dq.offer(new int[]{tmp[0], tmp[1], tmp[2] + 1});
                        }
                    } else if (!visit[nextY][nextX] && Graph[nextY][nextX] == 0) { // 그냥 길목인 경우
                        visit[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                    }
                }
            }

        }
        return -1;
    }
}
