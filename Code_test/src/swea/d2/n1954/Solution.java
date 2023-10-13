package swea.d2.n1954;

import java.util.Scanner;

/**
 *  달팽이숫자 문제 (자체 피드백)
 *  1. visit[][] 설계를 잊어서 살짝 헤멘점 -> IDE 없는만큼 설계를 조심하자
 *  2. nY nX 범위 확인할 때 내부 확인은 &&으로 바깥 확인은 ||로 하는 기본적인 실수를 했다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] answer = new int[N][N];
            boolean[][] visit = new boolean[N][N];
            int snail = 1;
            int[] dx = new int[]{1, 0, -1, 0};
            int[] dy = new int[]{0, 1, 0, -1};
            int direction = 0;
            int x = 0;
            int y = 0;
            while(true){
                if(snail > N*N) break;
//                System.out.print("시작 "  + y + " " + x + " ");
                answer[y][x] = snail++;
                visit[y][x] = true;
                int nextY = y + dy[direction];
                int nextX = x + dx[direction];
//                System.out.print(nextY + " " + nextX + " ");
                if((nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) || visit[nextY][nextX]){
//                    System.out.println("\n"+1);
                    direction = (direction + 1) % 4;
                    nextY = y + dy[direction];
                    nextX = x + dx[direction];
                }
                y = nextY;
                x = nextX;
//                System.out.println(snail - 1);
            }
            System.out.println("#" + test_case);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
