package baekjoon.math.pythagoras;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] list = new int[3];
        list[0] = sc.nextInt();
        list[1] = sc.nextInt();
        list[2] = sc.nextInt();
        Arrays.sort(list);
        while (!(list[0] == 0 && list[1] == 0 && list[2] == 0)) {
            if ((list[2] * list[2]) == list[0] * list[0] + list[1] * list[1]) {
                sb.append("right\n");
            }else{
                sb.append("wrong\n");
            }
            list[0] = sc.nextInt();
            list[1] = sc.nextInt();
            list[2] = sc.nextInt();
            Arrays.sort(list);
        }
        System.out.println(sb);
    }
}
