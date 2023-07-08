package baekjoon.sort.nlogn_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < N;i++){
            numbers.add(sc.nextInt());
        }
        Collections.sort(numbers);

        for(int value : numbers) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
