package swea.d2.n1974;

import java.util.*;
import java.io.FileInputStream;
// 1974. 스도쿠 검증
class Solution
{
    static int[][] Graph;
    static boolean[][] room;
    static boolean[] col; // 세로
    static boolean[] row; // 가로
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            Graph = new int[9][9];
            room = new boolean[3][3];
            col = new boolean[9];
            row = new boolean[9];

            boolean flag = true;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    Graph[i][j] = sc.nextInt();
                }
            }
            if(check1() && check2() && check3()){
                System.out.println("#"+test_case+" "+1);
            }else{
                System.out.println("#"+test_case+" "+0);
            }


        }
    }
    static boolean check1(){
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashSet<Integer> set = new HashSet<>();
                for(int k=i;k<i+2;k++){
                    for(int m=j;m<j+2;m++){
                        if(set.contains(Graph[k][m])){
                            return false;
                        }else set.add(Graph[k][m]);
                    }
                }
            }
        }
        return true;
    }
    static boolean check2(){
        for(int i=0;i<9;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(set.contains(Graph[i][j])){
                    return false;
                }else set.add(Graph[i][j]);
            }
        }
        return true;
    }
    static boolean check3(){
        for(int i=0;i<9;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(set.contains(Graph[j][i])){
                    return false;
                }else set.add(Graph[j][i]);
            }
        }
        return true;
    }
}