package baekjoon.implementations.gold.chicken;

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] Graph;
//    static boolean[][] visit;
    static int M;
    static ArrayList<int[]> chickenHouse = new ArrayList<>();
    static int chickenCnt = 0;
    static ArrayList<int[]> house = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static void range(){
        int sumRange = 0;
        for(int[] tmp:house){
            int tmpRange = Integer.MAX_VALUE;
            for (int i = 0; i < Graph.length; i++) {
                for (int j = 0; j < Graph.length; j++) {
                    if(Graph[i][j] == 2){
                        tmpRange = Math.min(tmpRange, Math.abs(tmp[0] - i) + Math.abs(tmp[1] - j));
                    }
                }
            }
            sumRange += tmpRange;
        }
        answer = Math.min(answer, sumRange);
    }
    static void dfs(int chk){
        System.out.println(chk);
        if(chk == chickenCnt - M){
            range();
            return;
        }

        for (int i = 0; i < chickenCnt; i++) {
            int tmp[] = chickenHouse.get(i);
            Graph[tmp[0]][tmp[1]] = 0;
            System.out.println(tmp[0] + " " + tmp[1]);
            dfs(chk + 1);
            Graph[tmp[0]][tmp[1]] = 2;

        }


    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 폐업 X, 치킨집의 수

        Graph = new int[N][N];
//        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int tmp = Integer.parseInt(st.nextToken());
                Graph[i][j] = tmp;
                if(tmp == 2) chickenHouse.add(new int[]{i, j});
                else if (tmp == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }
        chickenCnt = chickenHouse.size();

        dfs(0);
        System.out.println(answer);
        
    }
}