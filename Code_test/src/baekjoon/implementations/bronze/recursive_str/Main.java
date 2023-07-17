package baekjoon.implementations.bronze.recursive_str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String words = br.readLine();
            int[] answer = isPalindrome(words);
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }
        System.out.println(sb);
    }

    static int[] recursion(String words, int front, int rear){
        if(front >= rear) return new int[]{1, front + 1}; //
        else if (words.charAt(front) != words.charAt(rear)) return new int[]{0, front + 1};
        else return recursion(words, front+1, rear-1);
    }

    static int[] isPalindrome(String words){
        return recursion(words, 0, words.length() - 1);
    }

}
