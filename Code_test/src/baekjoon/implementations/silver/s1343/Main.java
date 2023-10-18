package baekjoon.implementations.silver.s1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp == 'X') {
                count++;
            } else {
                if (count % 2 == 1) {
                    System.out.println(-1);
                    System.exit(0);
                }

                while (count >= 2) {
                    if (count >= 4) {
                        sb.append("AAAA");
                        count -= 4;
                    } else {
                        sb.append("BB");
                        count -= 2;
                    }
                }
                sb.append(".");
            }
        }
        if (count % 2 == 1) {
            System.out.println(-1);
            System.exit(0);
        }

        while (count >= 2) {
            if (count >= 4) {
                sb.append("AAAA");
                count -= 4;
            } else {
                sb.append("BB");
                count -= 2;
            }
        }
        System.out.println(sb);
    }

}
