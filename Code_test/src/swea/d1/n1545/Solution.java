package swea.d1.n1545;
import java.util.Scanner;
// 1545. 거꾸로 출력해 보아요
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for (int i=0;i<=T;i++){
            System.out.print(T-i + " ");
        }
    }
}