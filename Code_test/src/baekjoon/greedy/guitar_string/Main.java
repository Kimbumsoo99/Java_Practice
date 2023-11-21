package baekjoon.greedy.guitar_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] guitar;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        guitar = new int[M];
        line = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            guitar[i] = Integer.parseInt(st.nextToken());
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(guitar);
        Arrays.sort(line);
        int packagePrice = Math.min(guitar[0], line[0] * 6);

        int answer = (N / 6) * packagePrice + Math.min(guitar[0], (N % 6) * line[0]);
        System.out.println(answer);

    }

}
