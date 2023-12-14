package baekjoon.implementations.bronze.b1267;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K;
        int Y = 0;
        int M = 0;
        for (int i = 0; i < N; i++) {
            K = sc.nextInt();
            Y += ((K / 30) + 1) * 10;
            M += ((K / 60) + 1) * 15;
        }
        if (Y == M) {
            System.out.println("Y M " + Y);
        } else if (Y < M) {
            System.out.println("Y " + Y);
        } else if (Y > M) {
            System.out.println("M " + M);
        }
    }
}
