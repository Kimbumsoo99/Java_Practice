package baekjoon.math.b5554;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int minute = 0;
            int second = 0;
            for (int i = 0; i < 4; i++) {
                int tmp = Integer.parseInt(br.readLine());
                second += tmp;
            }
            minute = second / 60;
            second %= 60;
            System.out.println(minute);
            System.out.println(second);
        }

}
