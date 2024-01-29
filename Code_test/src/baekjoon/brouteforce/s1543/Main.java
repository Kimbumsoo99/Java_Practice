package baekjoon.brouteforce.s1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pl = br.readLine();
        String n = br.readLine();
        int count = 0;
        for (int i = 0; i < pl.length(); i++) {
            if (pl.charAt(i) == n.charAt(0)) {
                boolean flag = isTrue(pl, n, i);
                if (flag) {
                    i += n.length() - 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static boolean isTrue(String pl, String n, int idx){
        for (int i = 0; i < n.length(); i++) {
            if (idx + i >= pl.length() || pl.charAt(idx + i) != n.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
