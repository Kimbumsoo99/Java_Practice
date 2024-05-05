package baekjoon.backtracking.gold.g2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N = 9, Graph[][] = new int[N][N], idx = 0;
    static boolean finish = false;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                if(Graph[i][j] == 0) list.add(new int[]{i, j});
            }
        }
        backtrack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(Graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void backtrack(){
        if (idx == list.size()) {
            finish = true;
            return;
        }
        int[] cur = list.get(idx);
        int cY = cur[0];
        int cX = cur[1];
        for (int i = 1; i < 10; i++) {
            Graph[cY][cX] = i;
            if (isMap(cY, cX) && isCol(cY, cX) && isRow(cY, cX)) {
                idx++;
                backtrack();
                idx--;
            }
            if(finish) return;
            Graph[cY][cX] = 0;
        }
    }



    static boolean isMap(int y, int x){
        int mY = y - y % 3;
        int mX = x - x % 3;
        for (int i = mY; i < mY + 3; i++) {
            for (int j = mX; j < mX + 3; j++) {
                if(i == y && j == x){
                    continue;
                }
                if (Graph[i][j] == Graph[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isCol(int y, int x){
        for (int i = 0; i < N; i++) {
            if (i != y && Graph[i][x] == Graph[y][x]) {
                return false;
            }
        }
        return true;
    }
    static boolean isRow(int y, int x){
        for (int i = 0; i < N; i++) {
            if (x != i && Graph[y][x] == Graph[y][i]) {
                return false;
            }
        }
        return true;
    }
}
