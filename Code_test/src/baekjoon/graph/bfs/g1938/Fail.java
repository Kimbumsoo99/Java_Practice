package baekjoon.graph.bfs.g1938;

public class Fail {
    static int[] dx = new int[]{0, 0, -1, 1, 0}, dy = new int[]{1, -1, 0, 0, 0};
    static int N, Graph[][], endT;
    static Train end;
/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        Graph = new int[N][N];

        Train start = new Train();
        end = new Train();

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (tmp[j] == 'B') {
                    start.idx.add(new int[] { i, j });
                } else if (tmp[j] == 'E') {
                    end.idx.add(new int[] { i, j });
                    Graph[i][j] = 2;
                } else {
                    Graph[i][j] = tmp[j] - '0';
                }
            }
        }

        start.sort();
        end.sort();

        if (start.idx.get(0)[0] == start.idx.get(1)[0]) { // 가로
            start.turn = 0;
        } else { // 세로
            start.turn = 1;
        }

        if (end.idx.get(0)[0] == end.idx.get(1)[0]) { // 가로
            end.turn = 0;
        } else { // 세로
            end.turn = 1;
        }
        endT = end.turn;
//		System.out.println(endT);

        System.out.println(bfs(start));
    }

    static int bfs(Train start) {
        ArrayDeque<Train> dq = new ArrayDeque<>();
        boolean[][][] visit = new boolean[2][N][N];
        dq.offer(start);
        visit[start.turn][start.idx.get(1)[0]][start.idx.get(1)[1]] = true;
        while (!dq.isEmpty()) {
            Train cur = dq.pollFirst();
            int[] mid = cur.idx.get(1);
			System.out.println(cur + " 첫 번째");

            // 처음은 그냥 확인
            for (int i = 0; i < 5; i++) {
                int nextY = mid[0] + dy[i];
                int nextX = mid[1] + dx[i];
                if (isMap(nextY, nextX, cur.turn) && !visit[cur.turn][nextY][nextX]) {
                    int[] first = cur.idx.get(0);
                    int[] last = cur.idx.get(2);
                    if (Graph[nextY][nextX] == 0) {
                        if (Graph[first[0] + dy[i]][first[1] + dx[i]] != 1
                                && Graph[last[0] + dy[i]][last[1] + dx[i]] != 1) {
                            Train next = new Train();
                            next.idx.add(new int[] { first[0] + dy[i], first[1] + dx[i] });
                            next.idx.add(new int[] { nextY, nextX });
                            next.idx.add(new int[] { last[0] + dy[i], last[1] + dx[i] });
                            next.turn = cur.turn;
                            next.cnt = cur.cnt + 1;
                            visit[cur.turn][nextY][nextX] = true;
							System.out.println("넣음요 : " + next);
                            dq.offer(next);
                        }
                    } else if (Graph[nextY][nextX] == 2 && endT == cur.turn) {
                        cur.sort();
						System.out.println(cur + " " +end);
                        if (end.idx.get(0)[0] == cur.idx.get(0)[0] + dy[i] && end.idx.get(0)[1] == cur.idx.get(0)[1] + dx[i]) {
                            return cur.cnt + 1;
                        }else {
                            if (Graph[first[0] + dy[i]][first[1] + dx[i]] != 1
                                    && Graph[last[0] + dy[i]][last[1] + dx[i]] != 1) {
                                Train next = new Train();
                                next.idx.add(new int[] { first[0] + dy[i], first[1] + dx[i] });
                                next.idx.add(new int[] { nextY, nextX });
                                next.idx.add(new int[] { last[0] + dy[i], last[1] + dx[i] });
                                next.turn = cur.turn;
                                next.cnt = cur.cnt + 1;
                                visit[cur.turn][nextY][nextX] = true;
//								System.out.println("넣음요 : " + next);
                                dq.offer(next);
                            }
                        }
                    }
                }
            }

            // 두 번째는 돌려서 확인

            boolean turnFlag = true;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!isMap(mid[0] + i, mid[1] + j) || Graph[mid[0] + i][mid[1] + j] == 1) {
                        turnFlag = false;
                    }
                }
            }
            if (!turnFlag)
                continue;

            if (cur.turn == 1) { // 세로 -> 가로
                cur.turn = 0;
                cur.idx.set(0, new int[] { mid[0], mid[1] - 1 });
                cur.idx.set(2, new int[] { mid[0], mid[1] + 1 });
            } else { // 가로 -> 세로
                cur.turn = 1;
                cur.idx.set(0, new int[] { mid[0] - 1, mid[1] });
                cur.idx.set(2, new int[] { mid[0] + 1, mid[1] });
            }

			System.out.println(cur + " 돌리기 성공 후 ! !");
            if(visit[cur.turn][mid[0]][mid[1]]) continue;

            for (int i = 0; i < 5; i++) {
                int nextY = mid[0] + dy[i];
                int nextX = mid[1] + dx[i];
                if (isMap(nextY, nextX, cur.turn) && !visit[cur.turn][nextY][nextX]) {
                    int[] first = cur.idx.get(0);
                    int[] last = cur.idx.get(2);
                    if (Graph[nextY][nextX] == 0) {
                        if (Graph[first[0] + dy[i]][first[1] + dx[i]] != 1
                                && Graph[last[0] + dy[i]][last[1] + dx[i]] != 1) {
                            Train next = new Train();
                            next.idx.add(new int[] { first[0] + dy[i], first[1] + dx[i] });
                            next.idx.add(new int[] { nextY, nextX });
                            next.idx.add(new int[] { last[0] + dy[i], last[1] + dx[i] });
                            next.turn = cur.turn;
                            next.cnt = cur.cnt + 1;
                            visit[cur.turn][nextY][nextX] = true;
							System.out.println("넣음요 : " + next);
                            dq.offer(next);
                        }
                    } else if (Graph[nextY][nextX] == 2 && endT == cur.turn) {
                        cur.sort();
                        if (end.idx.get(0)[0] == cur.idx.get(0)[0] + dy[i] && end.idx.get(0)[1] == cur.idx.get(0)[1] + dx[i]) {
                            return cur.cnt + 1;
                        }else {
                            if (Graph[first[0] + dy[i]][first[1] + dx[i]] != 1
                                    && Graph[last[0] + dy[i]][last[1] + dx[i]] != 1) {
                                Train next = new Train();
                                next.idx.add(new int[] { first[0] + dy[i], first[1] + dx[i] });
                                next.idx.add(new int[] { nextY, nextX });
                                next.idx.add(new int[] { last[0] + dy[i], last[1] + dx[i] });
                                next.turn = cur.turn;
                                next.cnt = cur.cnt + 1;
                                visit[cur.turn][nextY][nextX] = true;
//								System.out.println("넣음요 : " + next);
                                dq.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    static boolean isMap(int y, int x, int turn) {
        if (turn == 1) {
            return y - 1 >= 0 && x >= 0 && y + 1 < N && x < N;
        } else {
            return y >= 0 && x - 1 >= 0 && y < N && x + 1 < N;
        }
    }
}*/
}
