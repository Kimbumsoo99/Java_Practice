package baekjoon.implementations.bronze.b2953;

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int winner = 0;
        int score = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            if(sum > score){
                winner = i + 1;
                score = sum;
            }
        }
        sb.append(winner + " " + score);
        System.out.println(sb);
    }
}
