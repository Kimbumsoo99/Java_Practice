package swea.d2.n2001;
import java.util.Scanner;
import java.io.FileInputStream;
// 파리퇴치 D2
class Solution
{
    static int answer = 0;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] Graph = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    Graph[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<=N-M;i++){
                for(int j=0;j<=N-M;j++){
                    int tmp = 0;
                    for(int k = i;k<i+M;k++){
                        for(int m = j;m<j+M;m++){
                            tmp += Graph[k][m];
                        }
                    }
                    answer = Math.max(answer, tmp);
                }
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}