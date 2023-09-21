package baekjoon.implementations.bronze.b1264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

// 1264번, 모음의 개수, 브론즈 IV
public class Main {

    static HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int answer = 0;
            String tmp = br.readLine();
            if (tmp.equals("#")) {
                break;
            }

            for (char c : tmp.toCharArray()) {
                if (set.contains(c)) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

}
