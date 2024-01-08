package baekjoon.math.s1940;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoPointer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;
        while (startIndex < endIndex) {
            if (list.get(startIndex) + list.get(endIndex) == M) {
                startIndex++;
                endIndex--;
                count++;
            } else if (list.get(startIndex) + list.get(endIndex) > M) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        System.out.println(count);
    }

}
