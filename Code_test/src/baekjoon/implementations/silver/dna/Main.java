package baekjoon.implementations.silver.dna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            dna[i] = tmp;
        }

        ArrayList<Character> answer = new ArrayList<>();
        int answerInteger = 0;
        for (int i = 0; i < M; i++) {
            int max = 0;
            char correct = 127;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                char c = dna[j].charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (max < map.get(c) || (max == map.get(c) && c <= correct)) {
                    max = map.get(c);
                    correct = c;
                }
            }
            answer.add(correct);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(answer.get(i));
        }
        String ans = sb.toString();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ans.charAt(j) != dna[i].charAt(j)) {
                    answerInteger++;
                }
            }
        }
        System.out.println(ans);
        System.out.println(answerInteger);
    }
}
