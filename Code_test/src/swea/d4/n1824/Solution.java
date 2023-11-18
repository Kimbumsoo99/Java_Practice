package swea.d4.n1824;

import java.util.*;

// '?' 로 랜덤이 말이되나? 그거때문에 풀기싫어져서 안함.
public class Solution {
    static Character[][] map;
    static int memory;
    static boolean flag;
    static int direction = 0; // 0 우, 1 하, 2 좌, 3 상
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            map = new Character[N][M];
            memory = 0;
            flag = false;
            for (int i = 0; i < N; i++) {
                String tmp = sc.next();
                for (int j = 0; j < M; j++) {
                    map[i][j] = tmp.charAt(j);
                }
            }

            int current[] = new int[]{0, 0}; // 현재 위치
            
        }
    }

    static void cmd(char ch) {
        if (ch >= '0' && ch <= '9') {
            memory = ch - '0';
        } else if (ch == '<') {
            direction = 2;
        }else if (ch == '>') {
            direction = 0;
        }else if (ch == '^') {
            direction = 3;
        }else if (ch == 'v') {
            direction = 1;
        } else if (ch == '@') {
            flag = true; // 게임 종료
        } else if (ch == '+') {
            memory++;
            if (memory == 16) {
                memory = 0;
            }
        } else if (ch == '-') {
            memory--;
            if (memory < 0) {
                memory = 15;
            }
        } else if (ch == '?') {
            direction = ((int) (Math.random() * 4));
        } else if (ch == '_') {
        }
    }



}
