package baekjoon.implementations.silver.s2891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] team = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int tmp = Integer.parseInt(st.nextToken()) - 1;
            team[tmp]--;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int tmp = Integer.parseInt(st.nextToken()) - 1;
            team[tmp]++;
        }

        int answer = N;
        for (int i = 0; i < N; i++) {
            if (team[i] == -1) {
                if (i - 1 >= 0 && team[i - 1] > 0) {
                    team[i - 1]--;
                    answer--;
                } else if (i + 1 < N && team[i + 1] > 0) {
                    team[i + 1]--;
                    answer--;
                }
            } else {
                answer--;
            }
        }
        System.out.println(answer);


    }

}
