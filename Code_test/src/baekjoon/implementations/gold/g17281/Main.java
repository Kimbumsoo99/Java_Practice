package baekjoon.implementations.gold.g17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visit = new boolean[10];
    static int[] permS = new int[8];
    static int[] turn = new int[10];
    static int[][] arr;
    static int answer = 0, N;
    static boolean[] home = new boolean[3]; // 0 1루, 1 2루, 2 3루

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        arr = new int[N][10];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(0);
        System.out.println(answer);
    }

    static void setTurn() {
        boolean flag = false;
        for (int i = 1; i < 10; i++) {
            if (i == 4) {
                turn[i] = 1;
                flag = true;
                continue;
            }
            turn[i] = permS[flag ? i - 2 : i - 1];
        }
    }

    static int playGame() {
        int idx = 1; //
        int score = 0;
        int out = 0;
//		if (turn[1] == 5 && turn[2] == 6 && turn[3] == 7) {
//			System.out.println(Arrays.toString(turn));
//		}
        for (int ining = 0; ining < N; ining++) {
            while (true) {
//				System.out.println(ining + " " + idx + " " + turn[idx] + " " + Arrays.toString(arr[ining]));
                if (arr[ining][turn[idx]] == 0) {
//					System.out.println(turn[idx]);
                    if (++out == 3) {
                        out = 0;
                        home = new boolean[3];
                        if (++idx > 9)
                            idx = 1;
                        break;
                    }
                } else {
                    score += addScore(arr[ining][turn[idx]]);
//					if (turn[1] == 5 && turn[2] == 6 && turn[3] == 7) {
//						System.out.println(Arrays.toString(turn) + " " + score);
//						System.out.println(Arrays.toString(home) + " " + idx);
//					}
                }
                if (++idx > 9)
                    idx = 1;
            }
        }
        return score;
    }

    static int addScore(int add) {
        int score = 0;
        if (add == 4) {
            for (int i = 0; i < 3; i++) {
                if (home[i])
                    score++;
            }
            home = new boolean[3];
            score++;
            return score;
        }
        for (int i = 3 - add; i < 3; i++) {
            if (home[i])
                score++;
        }
        boolean newVisit[] = new boolean[3];
        for (int i = add; i < 3; i++) {
            newVisit[i] = home[i - add];
        }
        newVisit[add - 1] = true;
        home = newVisit;
        return score;
    }

    static void perm(int depth) {
        if (depth == 8) {
            setTurn();
//			System.out.println(Arrays.toString(turn));
            int count = playGame();
//			answer = Math.max(answer, count);
            if (answer < count) {
                answer = count;
//				System.out.println(Arrays.toString(turn));
            }
            return;
        }

        for (int i = 2; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permS[depth] = i;
                perm(depth + 1);
                visit[i] = false;
            }
        }
    }
}
