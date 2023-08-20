package baekjoon.implementations.bronze.rot13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(String tmp : str) {
            for (char c : tmp.toCharArray()) {
//                char tmpChar = c;
                if (c >= 'a' && c <= 'z') {
                    int tmpChar = (c - 'a' + 13) % 26;
                    sb.append((char) (tmpChar + 'a'));
                }
                else if (c >= 'A' && c <= 'Z') {
                    int tmpChar = (c - 'A' + 13) % 26;
                    sb.append((char) (tmpChar + 'A'));
                }
                else{
                    sb.append(c);
                }
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
