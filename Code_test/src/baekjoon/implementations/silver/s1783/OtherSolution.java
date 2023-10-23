package baekjoon.implementations.silver.s1783;
import java.util.*;
public class OtherSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        if(N == 1) System.out.println(1);
        else if(N == 2) System.out.println(Math.min(4, (M + 1) / 2));
        else if(M < 7) System.out.println(Math.min(4, M));
        else System.out.println(M - 7 + 5);
    }
}
