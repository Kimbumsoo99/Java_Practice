package baekjoon.implementations.silver.the_game_of_death;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            map.put(i, tmp);
        }
        int current = 0;
        int answer = 0;
        visit[current] = true;
        while (true) {
            answer++;
            current = map.get(current);
            if (visit[current]) {
                answer = -1;
                break;
            } else if (current == K) {
                break;
            }
            visit[current] = true;
        }
        System.out.println(answer);
    }

}
