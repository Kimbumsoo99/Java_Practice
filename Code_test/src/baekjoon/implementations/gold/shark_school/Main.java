package baekjoon.implementations.gold.shark_school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

// 21608번, 골드 V, 상어 초등학교
public class Main {

    static int[][] Graph;
    static boolean[][] visit;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int likeScore[] = new int[]{0, 1, 10, 100, 1000};
    static int N;
    static int answer = 0;
    static HashMap<Integer, int[]> seat = new HashMap<>(); //자리에 이미 앉은 번호
    static HashMap<Integer, HashSet<Integer>> love = new HashMap<>(); //좋아하는 번호


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            HashSet<Integer> tmp = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }
            love.put(student, tmp);
            takeSeat(student);
        }
        countLikeScore();
//        draw();
        System.out.println(answer);
    }
    static void countLikeScore() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nextX = j + dx[k];
                    int nextY = i + dy[k];
                    if (nextY > 0 && nextX > 0 && nextY <= N && nextX <= N) {
                        if (love.get(Graph[i][j]).contains(Graph[nextY][nextX])) {
                            count++;
                        }
                    }
                }
                answer += likeScore[count];
            }
        }
    }
    static void draw() {
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N + 1; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void takeSeat(int student) {
//        System.out.println(student);
        int current[] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE,
            Integer.MIN_VALUE};
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visit[i][j]) {
//                    System.out.println(i + ", " + j);
                    int tmp[] = new int[]{i, j, 0, 0}; // y, x, love cnt, blank cnt
                    for (int k = 0; k < 4; k++) {
                        int nextX = j + dx[k];
                        int nextY = i + dy[k];
                        if (nextY > 0 && nextX > 0 && nextY <= N && nextX <= N) {
                            if (!visit[nextY][nextX]) {
                                tmp[3] += 1;
                            } else if (love.get(student).contains(Graph[nextY][nextX])) {
                                tmp[2] += 1;
                            }
                        }
                    }
//                    System.out.println(
//                        "개수 y,x " + tmp[0] + " " + tmp[1] + " lC = " + tmp[2] + " bC = " + tmp[3]);
                    current = getInts(current, tmp);
                }
            }
        }
        Graph[current[0]][current[1]] = student;
        visit[current[0]][current[1]] = true;
//        System.out.println(student + "의 선택 " + current[0] + " " + current[1]);
    }

    private static int[] getInts(int[] current, int[] tmp) {
        if (current[2] < tmp[2]) { // 좋카가 높다면
            current = tmp;
        } else if (current[2] == tmp[2]) { // 좋카는 같고, 빈 칸이 많다면
            if (current[3] < tmp[3]) {
                current = tmp;
            } else if (current[3] == tmp[3]) { // 좋카, 빈칸 같고 행이 작다면
                if (current[0] > tmp[0]) {
                    current = tmp;
                } else if (current[0] == tmp[0]) { //좋카,빈칸 같고 행, 열 둘다 작다면
                    if (current[1] > current[1]) {
                        current = tmp;
                    }
                }
            }
        }
        return current;
    }

//    static void takeSeat(int student) {
//        HashMap<Integer, int[]> alreadySeat = new HashMap<>(); // 좋아하는 사람이 자리에 앉아있는지 여부
//        Iterator<Integer> it = love.get(student).iterator();
//
//        // 좋아하는 사람이 앉아있는지 확인
//        while (it.hasNext()) {
//            int loveStudent = it.next();
//            if (seat.containsKey(loveStudent)) {
//                alreadySeat.put(loveStudent, seat.get(loveStudent));
//            }
//        }
//
//        if (alreadySeat.isEmpty()) { // 좋아하는 사람이 아무도 없는 경우
//            HashMap<String, int[]> map = new HashMap<>();
//            ArrayList<int[]> list = new ArrayList<>(); // int[3]{y, x, count}
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    if (!visit[i][j]) {
//                        extracted(map, i, j);
//                    }
//                }
//            }
//
//        } else { // 좋아하는 사람이 있는 경우
//            HashMap<String, int[]> map = new HashMap<>();
//            ArrayList<int[]> list = new ArrayList<>(); // int[4]{y, x, 좋아하는 사람 카운트, 빈 칸}
//            Iterator<Integer> it2 = alreadySeat.keySet().iterator();
//            // 좋아하는 사람에 대해서 주변 빈자리를 탐색
//            while (it2.hasNext()) {
//                int loveSt = it2.next(); // 좋아하는 사람 번호 -> 자리를 구해야함.
//                int[] lovedSeat = seat.get(loveSt);
//
//                // 좋아하는 주변 사람의 자리가 있는지 확인
//                for (int i = 0; i < 4; i++) {
//                    int nextY = lovedSeat[0] + dy[i];
//                    int nextX = lovedSeat[1] + dx[i];
//                    if (nextY > 0 && nextX > 0 && nextY <= N * N && nextX < N * N) {
//                        if (!visit[nextY][nextX]) {
////                            int[] blankSeat = new int[]{nextY, nextX};
//                            extracted(map, nextY, nextX);
//                        }
//                    }
//                }
//            }
//            for (int[] value : map.values()) {
//                list.add(value);
//            }
//            Collections.sort(list, (o1, o2) -> {
//                if (o1[2] == o2[2]) {
//                }
//                return o1[2] - o2[2];
//            });
//        }
//    }

    private static void extracted(HashMap<String, int[]> map, int nextY, int nextX) {
        String tmp = nextY + "." + nextX;
        if (map.containsKey(tmp)) {
            int[] seatCount = map.get(tmp);
            seatCount[2] += 1;
            map.put(tmp, seatCount);
        } else {
            map.put(tmp, new int[]{nextY, nextX, 1});
        }
    }
}
