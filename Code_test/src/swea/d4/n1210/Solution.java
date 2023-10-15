package swea.d4.n1210;

import java.util.*;
import java.io.FileInputStream;

// 1210. [S/W 문제해결 기본] 2일차 - Ladder1
class Solution {

    static int[][] Graph;
    static boolean[][] visit;
    static int dx[] = new int[]{-1, 1};
    static ArrayList<Integer> start;

    public static void main(String args[]) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int T;
            T = 10;

            for (int test_case = 1; test_case <= T; test_case++) {
                int testCase = sc.nextInt();
                Graph = new int[100][100];
                visit = new boolean[100][100];
                start = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100; j++) {
                        Graph[i][j] = sc.nextInt();
                        if (i == 0 && Graph[i][j] == 1) {
                            start.add(j);
                        }
                        if (Graph[i][j] == 1) {
                            visit[i][j] = true;
                        }
                    }
                }
                boolean goal;
                int answer = -1;
//                for (int i = 0; i < start.size(); i++) {
//                    System.out.print(start.get(i) + " ");
//                }
//                System.out.println();
                for (Integer point : start) {
//                    System.out.println("==========" + point + "==========");
                    goal = game(point);
                    if (goal) {
                        answer = point;
                        break;
                    }
                }
                System.out.println("#" + testCase + " " + answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean game(int s) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, s});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            if (Graph[tmp[0]][tmp[1]] == 2) {
                return true;
            } else if (tmp[0] == Graph.length - 1) {
                break;
            }
            for (int i = 0; i < 2; i++) {
                int nextY = tmp[0];
                int nextX = tmp[1] + dx[i];
//                System.out.println(s + " " + nextY + " " + nextX);
                if (nextX >= 0 && nextX < 100 && visit[nextY][nextX]) {
                    while (nextX >= 0 && nextX < 100 && visit[nextY][nextX]) {
                        nextX += dx[i];
                    }
                    dq.offer(new int[]{nextY + 1, nextX - dx[i]});
//                    System.out.println("1삽입 " + s + " " + (nextY + 1) + " " + (nextX - dx[i]));
                }
            }
            if (dq.isEmpty()) {
                dq.offer(new int[]{tmp[0] + 1, tmp[1]});
//                System.out.println("2삽입 " + s + " " + (tmp[0] + 1) + " " + tmp[1]);
            }
        }
        return false;
    }
}

