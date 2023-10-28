package swea.d4.n1868;

import java.util.Scanner;
// 나중에 다시 풀어보길 꼭!!
// 현재 코드가 너무 더럽다 정답은 맞췄음.
// 1868번 파핑파핑 지뢰찾기 D4
class WantRefactor {
    static boolean[][] visit;
    static int[][] mine;
    static int answer;
    static int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            answer = 0;
            // 지뢰 맵 생성
            visit = new boolean[N][N];
            mine = new int[N][N];
            for (int i = 0; i < N; i++) {
                String tmp = sc.next();
                for (int j = 0; j < N; j++) {
                    if (tmp.charAt(j) == '*') {
                        visit[i][j] = true; // 탐색 X
                        mine[i][j] = -1;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mine[i][j] != -1 && !visit[i][j]) {
//                        System.out.println("37번 줄: " + i + " " + j);
                        search(i, j, 0, N);
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void search(int y, int x, int chain, int N) {
        boolean chainFlag = false;
        boolean mineFlag = false; // 탐색 중 지뢰 발견시 ture
        if (visit[y][x]) {
            return;
        }
        visit[y][x] = true;

        int mineCount = 0;
        for (int i = 0; i < dx.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N) {
                if (mine[nextY][nextX] == -1) {
                    mineCount++;
                    mineFlag = true;
                } else if (chain == 0 && !chainFlag && !visit[nextY][nextX]
                    && mine[nextY][nextX] != -1) {
                    chainFlag = chain(nextY, nextX, N); // 다음 경로의 8칸이 빈칸인지 확인
                    // 만약 8칸이 빈칸이라면, 현재 칸에 대해서는 추가가 필요없음.
                }
            }
        }
        mine[y][x] = mineCount;

        if (!mineFlag) { // 지뢰가 없다면, 주변을 다 보여줘야함.
            if (chain == 0) {
//                System.out.println(y + " " + x);
                answer++;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N) {
                    if (!visit[nextY][nextX]) {
                        search(nextY, nextX, 1, N); // 탐색만 하고 오기
                    }
                }
            }
        } else if (mineFlag && chain == 1) { // 지금 현재 탐색 중인데, 주변에 지뢰가 있다면
            return;
        } else if (mineFlag && !chainFlag) { // 연결된 것 중 자신을 확인해줄 것이 없다면
//            System.out.println(y + " " + x);
            answer++;
        }
    }

    private static boolean chain(int y, int x, int N) {
        for (int i = 0; i < dx.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N) {
                if (mine[nextY][nextX] == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}