package baekjoon.implementations.gold.chicken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] Graph;
    //    static boolean[][] visit;
    static int M;
    static Queue<int[]> chickenHouse = new LinkedList<>();
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
    static void dfs(int start, int start2, int chk){
//        System.out.println(chk);
        if(chk == chickenHouse.size() - M){
            range();
            return;
        }

        for (int i = start; i < Graph.length; i++) {
            for (int j = 0; j < Graph.length; j++) {
                if(Graph[i][j] == 2){
                    Graph[i][j] = 0;
                    dfs(i, j, chk + 1);
                    Graph[i][j] = 2;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
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
                if(tmp == 2) chickenHouse.offer(new int[]{i, j});
                else if (tmp == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
