package baekjoon.implementations.silver.word_reverse2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        boolean tag = false;
        for (int i = 0; i < words.length(); i++) {
            char word = words.charAt(i);
            if (word == '<' && sb.length() != 0) {
                tag = true;
                answer.append(sb.reverse()).append('<');
                sb = new StringBuilder();
                continue;
            } else if (word == '<') {
                tag = true;
            }
            if (word == '>') {
                tag = false;
                answer.append(sb).append('>');
                sb = new StringBuilder();
                continue;
            }
            if (word == ' ' && !tag) {
                answer.append(sb.reverse()).append(' ');
                sb = new StringBuilder();
                continue;
            }
            sb.append(word);
        }
        answer.append(sb.reverse());
        System.out.println(answer);
    }

}
