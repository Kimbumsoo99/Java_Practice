package baekjoon.brouteforce.suger_rush;

import java.util.Scanner;

public class Main {
    public static int broute(int N){
        int count = 0;
        while(true){
            if(N % 5 == 0) return count + N / 5;
            else if(N < 0){
                return -1;
            }
            N -= 3;
            count++;
        }
    }
    public static int firstSol(int N){
        int five = N / 5;
        int three = N % 5;
        int answer = -1;
//        System.out.println(five + " " + three);
        for(int i = 0; i< 3;i++){
            if(three % 3 != 0){
                five--;
                if(five < 0) {
                    return -1;
                }
                three += 5;
            }else{
                answer = five + (three / 3);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(broute(N));
        System.out.println(firstSol(N));
    }

}
