package baekjoon.implementations.gold.string_boom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemoryOver {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String boomStr = br.readLine();
        boolean flag = false;
        while (true) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == boomStr.charAt(0)) {
                    if (input.substring(i, i + boomStr.length()).equals(boomStr)) {
//                        System.out.println(input);
                        input = input.substring(0, i) + input.substring(i + boomStr.length());
//                        System.out.println(input);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                break;
            }
            flag = false;
        }
        if (input.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(input);
        }
    }

}
