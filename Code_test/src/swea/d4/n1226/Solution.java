package swea.d4.n1226;
import java.util.*;

class Solution {
    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int T;
            T = 10;

            for (int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt(); // 테케
                Graph = new int[16][16];
                visit = new boolean[16][16];
                int start[] = new int[2];
                int finish[] = new int[2];
                for (int i = 0; i < 16; i++) {
                    String tmp = sc.next();
                    for (int j = 0; j < 16; j++) {
                        int p = tmp.charAt(j) - '0';
                        Graph[i][j] = p;
                        if (p == 2) {
                            start = new int[]{i, j};
                        } else if (p == 3) {
                            finish = new int[]{i, j};
                        }
                    }
                }
                if (bfs(start)) {
                    System.out.println("#" + test_case + " " + 1);
                } else {
                    System.out.println("#" + test_case + " " + 0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static boolean bfs(int[] start) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        visit[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextY < 16 && nextX < 16) {
                    if (Graph[nextY][nextX] == 0 && !visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX});
                    } else if (Graph[nextY][nextX] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
