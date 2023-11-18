package baekjoon.implementations.gold.sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static boolean flag = false;
    static int[][] Graph = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 9; j++) {
                Graph[i][j] = tmp.charAt(j) - '0';
            }
        }

        recur(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Graph[i][j]);
            }
            System.out.println();
        }
    }

    private static void recur(int y, int x) {
        if (Graph[8][8] != 0 && y == 8 && x == 8) {
            flag = true;
            return;
        }

        if (Graph[y][x] != 0) {
            if (x + 1 < 9) {
                recur(y, x + 1);
            } else if (y + 1 < 9) {
                recur(y + 1, 0);
            }
            return;
        }

        HashSet<Integer> set = new HashSet<>(); // 존재하지 않는 수에 대한 set
        for (int i = 1; i < 10; i++) {
            set.add(i);
        }


        checkCol(set, x);
        checkRow(set, y);
        checkSquare(set, y / 3, x / 3);

        if (set.size() == 0) {
            return;
        }

        for (Integer num : set) {
            Graph[y][x] = num;
            recur(y, x);
            if (flag) {
                return;
            }
            Graph[y][x] = 0;
        }
    }

    private static void checkSquare(HashSet<Integer> set, int y, int x) {
        int tmpY = y * 3;
        int tmpX = x * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Graph[i + tmpY][j + tmpX] != 0) {
                    set.remove(Graph[i + tmpY][j + tmpX]);
                }
            }
        }
    }

    private static void checkRow(HashSet<Integer> set, int y) {
        for (int i = 0; i < 9; i++) {
            if (Graph[y][i] != 0) {
                set.remove(Graph[y][i]);
            }
        }
    }

    private static void checkCol(HashSet<Integer> set,  int x) {
        for (int i = 0; i < 9; i++) {
            if (Graph[i][x] != 0) {
                set.remove(Graph[i][x]);
            }
        }
    }

}
