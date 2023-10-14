package swea.d4.n1249;

import java.util.*;
import java.io.FileInputStream;
// 1249. [S/W 문제해결 응용] 4일차 - 보급로
class Solution
{
    static int[][] Graph;
    static int[][] dp;
    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{1, 0, 0, -1};
    static boolean[][] visit;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            Graph = new int[N][N];
            dp = new int[N][N];
            visit = new boolean[N][N];
            for(int i=0;i<N;i++){
                String str = sc.next();
                for(int j=0;j<N;j++){
                    int tmp = Integer.parseInt(str.substring(j,j+1));
                    Graph[i][j] = tmp;
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;
            bfs();
            System.out.println("#"+test_case+" "+dp[N-1][N-1]);
        }
    }
    static void bfs(){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        while(!dq.isEmpty()){
            int[] tmp = dq.pollFirst();
            for(int i=0;i<4;i++){
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if(nextY >=0&&nextX>=0&&nextX<Graph.length&&nextY<Graph.length){
                    if(dp[nextY][nextX] > dp[tmp[0]][tmp[1]] + Graph[nextY][nextX]){
                        dq.offer(new int[]{nextY, nextX});
                        dp[nextY][nextX] = dp[tmp[0]][tmp[1]] + Graph[nextY][nextX];
                    }
                }
            }
        }
    }
}