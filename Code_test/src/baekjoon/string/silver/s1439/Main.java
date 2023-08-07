package baekjoon.string.silver.s1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뒤집기, 실V
public class Main {

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pr = br.readLine();
        char current = pr.charAt(0);
        int count[] = new int[2];
        count[0] = count[1] = 0;
        int i;
        if (current == '1') {
            count[1]++;
            i = 1;
        } else {
            count[0]++;
            i = 0;
        }
//        System.out.println(i);

        for (char c : pr.toCharArray()) {
            if (c != current) {
                current = c;
                i = (i + 1) % 2;
                count[i]++;
            }
        }
//        while (isNotS(pr)){
//
//        }
        System.out.println(count[0] > count[1] ? count[1] : count[0]);
    }

    static boolean isNotS(String pr){
        char start = pr.charAt(0);
        for(char c : pr.toCharArray()){
            if (c != start) {
                return true;
            }
        }
        return false;
    }

    static String cardReverse(String pr, int x1, int x2){
        count++;
        String tmp = "";
        if (pr.charAt(x1) == '0') {
            for (int i = 0; i < x2 - x1; i++) {
                tmp += '1';
            }
        }else{
            for (int i = 0; i < x2 - x1; i++) {
                tmp += '0';
            }
        }
        return pr.substring(0, x1) + tmp + pr.substring(x2);
    }

}
