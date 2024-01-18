package baekjoon.backtracking.gold.g9663;

import java.util.Scanner;

class SlowMain
{
    static int[][] Graph;
    static boolean[][] visit;
    static int count;
    public static void main(String args[]) throws Exception
    {
        try{
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            Graph = new int[N][N];
            visit = new boolean[N][N];
            count = 0;
            for(int j=0;j<N;j++){
                Graph[0][j] = 1;
                dfs(0, j, 1, N);
                Graph[0][j] = 0;
            }
            System.out.println(count);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static void dfs(int y, int x, int cnt, int N){
        // 재귀 종료 조건
        if(cnt == N){
            count++;
            return;
        }

        for(int j=0;j<N;j++){
            if(isQueen(y+1, j)){
                Graph[y+1][j] = 1;
                dfs(y+1, j, cnt+1, N);
                Graph[y+1][j] = 0;
            }
        }
    }
    static boolean isQueen(int y, int x){
        int N = Graph.length;
        for(int i=0;i<Graph.length;i++){
            if(Graph[y][i] == 1) return false;
            if(Graph[i][x] == 1)return false;
            if(x-i>=0 && y-i>=0){
                if(Graph[y-i][x-i] == 1){
                    return false;
                }
            }
            if(x-i>=0 && y+i<N){
                if(Graph[y+i][x-i] == 1){
                    return false;
                }
            }
            if(x+i<N && y+i<N){
                if(Graph[y+i][x+i] == 1){
                    return false;
                }
            }
            if(x+i<N && y-i>=0){
                if(Graph[y-i][x+i] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}
