package baekjoon.implementations.gold.magic_shark_rain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 마법사 상어 비바라기, 골드V, 21610
public class Main {
    static int[][] Graph;
    static boolean[][] cloud;
    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    static ArrayList<int[]> cloudList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new int[N][N];
        cloud = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rainInit(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1; // 방향
            int s = Integer.parseInt(st.nextToken()); // 횟수
            cloudMove(d, s);
            cloudCreate(N);
//            draw(N);
//            drawCloud();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += Graph[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void drawCloud() {
        for (int[] ints : cloudList) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    private static void draw(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void cloudCreate(int N) {
        // 3. 구름이 모두 사라진다.
        cloudList.clear();

//        System.out.println("Create 전");
//        draw(N);
//        System.out.println("Create 후");
        // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    // 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
                    cloud[i][j] = false;
                }
                else if (Graph[i][j] > 1 && !cloud[i][j]) {
                    cloud[i][j] = true;
                    Graph[i][j] -= 2;
                    cloudList.add(new int[]{i, j});
                }
            }
        }
//        drawCloud();
    }

    private static void cloudMove(int d, int s) {
        ArrayList<int[]> movedCloudList = new ArrayList<>();
        for (int[] c : cloudList) {
//            System.out.println("기존 클라우드 " + c[0] + " " + c[1]);
            cloud[c[0]][c[1]] = false;
            // 1. 모든 구름이 d 방향으로 s칸 이동한다.
            int moveY = dy[d] * (s % Graph.length);
            int nextY = c[0] + moveY;
            if (nextY < 0) {
                nextY = Graph.length + nextY;
            } else if (nextY >= Graph.length) {
                nextY = nextY % Graph.length;
            }
            int moveX = dx[d] * (s % Graph.length);
            int nextX = c[1] + moveX;
            if (nextX < 0) {
                nextX = Graph.length + nextX;
            } else if (nextX >= Graph.length) {
                nextX = nextX % Graph.length;
            }

//            System.out.println("이동 클라우드 " + nextY + " " + nextX);
            movedCloudList.add(new int[]{nextY, nextX});
            // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            Graph[nextY][nextX]++;
        }

        // 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용
        // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
        for (int[] c : movedCloudList) {
            cloud[c[0]][c[1]] = true;
//            System.out.println("현재 위치 : " + c[0] + " " + c[1] + " " + Graph[c[0]][c[1]]);
            for (int i = 1; i < 8; i += 2) {
                int nextY = c[0] + dy[i];
                int nextX = c[1] + dx[i];
                if (nextY >= 0 && nextX >= 0 && nextX < Graph.length && nextY < Graph.length) {
//                    System.out.println(nextY + " " + nextX + " " + Graph[nextY][nextX]);
                    if (Graph[nextY][nextX] > 0) {
                        Graph[c[0]][c[1]]++;
                    }
                }
            }
//            System.out.println("추가 위치 : " + c[0] + " " + c[1] + " " + Graph[c[0]][c[1]]);
        }
    }

    private static void rainInit(int N) {
        cloud[N - 1][0] = true;
        cloud[N - 1][1] = true;
        cloud[N - 2][0] = true;
        cloud[N - 2][1] = true;
        cloudList.add(new int[]{N - 1, 0});
        cloudList.add(new int[]{N - 1, 1});
        cloudList.add(new int[]{N - 2, 0});
        cloudList.add(new int[]{N - 2, 1});
    }
}
