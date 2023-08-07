package baekjoon.string.silver.s10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 30
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        for(char n : num.toCharArray()){
            list.add(String.valueOf(n));
        }
        Collections.sort(list, Collections.reverseOrder());
        if(isThree(list) && list.get(list.size() - 1).equals("0")){
            draw(list);
        }
        else System.out.println(-1);
    }

    static void draw(ArrayList<String> tmp){
        for (int i = 0; i < tmp.size(); i++) {
            System.out.print(tmp.get(i));
        }
    }
    static boolean isThree(ArrayList<String> list){
        int N = 0;
        for(String s : list){
            N += Integer.parseInt(s);
        }
        if (N % 3 == 0) {
            return true;
        }
        return false;
    }
}
