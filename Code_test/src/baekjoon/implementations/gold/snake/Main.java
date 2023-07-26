package baekjoon.implementations.gold.snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph; // 0 길, 1 사과
    static int[][] dir = {
        {1, 0},  // → ↓ ← ↑
        {0, 1},
        {-1, 0},
        {0, -1}};
    static Queue<int[]> directionQ = new LinkedList<>(); // 1 -> 오른쪽, 0 -> 왼쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            Graph[y - 1][x - 1] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int dr = s.equals("D") ? 1 : 0;
            directionQ.offer(new int[]{sec + 1, dr});
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(Graph[i][j] + " ");
//            }
//            System.out.println();
//        }
        int answer = gameStart();
        System.out.println(answer);
    }

    static int gameStart(){
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.offerLast(new int[]{0, 0});
        int directChange[] = directionQ.poll();
        int time = 0;
        int arrow = 0; // 현재 방향 0 → 1 ↓ 2 ← 3 ↑
        while (true) {
            time++;
            if (directChange[0] == time) {
//                System.out.println("time : " + (directChange[0]-1) + " " + directChange[1]);
                if (directChange[1] == 1) { // R 방향
                    arrow = (arrow + 1) % 4;
                }else{ // L 방향
                    arrow = (arrow + 3) % 4;
//                    System.out.println(arrow);
                }
                if (!directionQ.isEmpty()) {
                    directChange = directionQ.poll();
                }
            }
            int[] tmp = snake.peekLast();
//            if (time < 10) {
//                System.out.println(tmp[0] + " " + tmp[1]);
//            }
            int nextX = tmp[0] + dir[arrow][0];
            int nextY = tmp[1] + dir[arrow][1];


            // 자기자신의 몸과 부딪히는 경우 게임 종료
            if (nextY >= 0 && nextX >= 0 && nextY < Graph.length && nextX < Graph.length) {
                if (bodyShot(snake, new int[]{nextX, nextY})) {
                    break;
                }
                // 사과가 있다면 사과가 없어지고 꼬리 안움직임
                else if (Graph[nextY][nextX] == 1) {
                    Graph[nextY][nextX] = 0;
                    snake.offerLast(new int[]{nextX, nextY});
                }
                // 사과 없으면 몸길이 줄이기
                else {
                    snake.pollFirst();
                    snake.offerLast(new int[]{nextX, nextY});
                }
            }else{ // 벽과 부딪힘 게임 종료
                break;
            }
//            if (time < 21) {
//                System.out.println(time + "  " + nextX + " " + nextY + " " + Graph[nextY][nextX] + " " + snake.size());
//            }
        }
        return time;
    }
    static boolean bodyShot(ArrayDeque<int[]> snake, int[] correct){
        for(int[] tmp : snake){
            if(tmp[0] == correct[0] && tmp[1] == correct[1]) return true;
        }
        return false;
    }
}
