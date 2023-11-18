package baekjoon.greedy.sensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] sensor;
    static ArrayList<Integer> diff = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sensor = new int[N];
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        for (int i = 0; i < N - 1; i++) {
            diff.add(sensor[i + 1] - sensor[i]);
        }

        Collections.sort(diff);
        int exclude = M - 1;
        int answer = 0;
        for (int i = 0; i < diff.size() - exclude; i++) {
            answer += diff.get(i);
        }
        System.out.println(answer);
    }

}
