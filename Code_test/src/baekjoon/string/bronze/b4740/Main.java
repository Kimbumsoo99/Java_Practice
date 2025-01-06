package baekjoon.string.bronze.b4740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("***")) {
                break;
            }
            StringBuilder tmp = new StringBuilder();
            tmp.append(str);
            tmp.reverse();
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}