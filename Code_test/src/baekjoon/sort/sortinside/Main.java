package baekjoon.sort.sortinside;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = String.valueOf(sc.nextInt());
        ArrayList<Integer> list = new ArrayList<>();
        for(char w : N.toCharArray()){
            list.add(Character.getNumericValue(w));
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
//            System.out.println(i);
            sb.append(i);
        }
        System.out.println(sb.toString());
    }

}
