package baekjoon.implementations.silver.s2828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int basketL = 1;
        int basketR = M;
        int J = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());
            int move = 0;
            if (basketL > apple) {
                move = apple - basketL;
            } else if (basketR < apple) {
                move = apple - basketR;
            }
            basketL += move;
            basketR += move;
            answer += Math.abs(move);
        }
        System.out.println(answer);
    }

}
