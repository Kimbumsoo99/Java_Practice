package baekjoon.implementations.gold.chicken_delivery;

import java.util.*;
import java.io.*;

public class Main{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] Graph;
    static boolean[][] visit;
    static Queue<int[]> chik = new LinkedList<>();
    void dfs(){
        if(chik.size() == 3){
            
        }
    }
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int chk = Integer.parseInt(st.nextToken());

        Graph = new int[N][N];
        visit = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int tmp = Integer.parseInt(st.nextToken());
                Graph[i][j] = tmp;
                if(tmp == 2) chik.offer(new int[]{i, j});
            }
        }

        dfs(chk);
        
    }

}