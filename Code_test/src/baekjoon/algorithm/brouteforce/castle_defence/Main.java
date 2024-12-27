package baekjoon.brouteforce.castle_defence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static int range = 0;
    static int N;
    static int M;
    static int[][] Graph;
    static int[][] gameMap;
    static int enemy = 0;
    static boolean[] arrow;

    static int[] dx = {-1, 0, 1};
    static int[] dy = {0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        gameMap = new int[N][M];
        arrow = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0);
        System.out.println(enemy);
    }

    static void copy(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                gameMap[i][j] = Graph[i][j];
            }
        }
    }

    static void recursive(int depth){
        // index 위치 등을 줘서 재귀를 줄일 수 있을 것 같음.
        if(depth >= 3){
            // 3명의 궁병을 배치 완료
//            System.out.println("recursive depth 성공");
            copy(); // 새로운 맵 생성, 궁수 배치 완료
            int kill = gameStart(arrow);
//            System.out.println("game Finish kill 개수: " + kill);
            enemy = Math.max(enemy, kill);
            return;
        }

        // 궁병 배치
        for (int i = 0; i < M; i++) {
            if (!arrow[i]) {
                arrow[i] = true;
                recursive(depth + 1);
                arrow[i] = false;
            }
        }
    }

    static int gameStart(boolean[] arrow){
        int kill = 0;
//        System.out.println(
//            "game Start 성공" + " 궁수위치 " + arrow[0] + arrow[1] + arrow[2] + arrow[3] + arrow[4]);
//        draw();
        while (!isZeroEnemy()){
            // 게임 진행이 가능한 경우
            ArrayList<int[]> killList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (arrow[i] == true) {
                    int[] killIndex = shoot(i);
                    if (killIndex != null) {
                        killList.add(killIndex);
                    }
                }
            }

            Iterator<int[]> it = killList.iterator();
            while (it.hasNext()) {
                // 중복 좌표가 존재할 수 있음. 배열은 Set과 같은 곳에 저장해도 어처피 중복 확인을 못함. 따라서 ArrayList로 구현
                // 별로 문제 안생길듯해서 냅둠.
                int[] tmp = it.next();
                if (gameMap[tmp[0]][tmp[1]] == 1) {
                    kill++;
                    gameMap[tmp[0]][tmp[1]] = 0;
                }
            }
//            draw();
//            System.out.println("Round 끝 kill 개수: " + kill);
            nextRound();
        }
        return kill;
    }

    static int[] shoot(int index){
        if (gameMap[N - 1][index] == 1) {
            // 첫 번째 위치(바로 위)가 적인 경우
//            System.out.println("첫 번째 위치 " + (N-1) + " " + index);
            return new int[]{N - 1, index};
        }
        boolean visit[][] = new boolean[N][M];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{N - 1, index, 1});
        visit[N - 1][index] = true;
        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
            if (tmp[2] >= range) {
                return null;
            }

            for (int i = 0; i < 3; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (!visit[nextY][nextX] && gameMap[nextY][nextX] == 0) {
                        dq.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                    } else if (gameMap[nextY][nextX] == 1) {
                        return new int[]{nextY, nextX};
                    }
                }
            }
        }
        return null;
    }

    static boolean isZeroEnemy(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (gameMap[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void nextRound(){
        int[][] newGraph = new int[N][M];
        for (int i = 1; i < N; i++) {
            newGraph[i] = gameMap[i - 1];
        }
        gameMap = newGraph;
    }

    static void draw(){
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[0].length; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
