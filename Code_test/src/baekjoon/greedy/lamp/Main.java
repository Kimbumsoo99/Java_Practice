package baekjoon.greedy.lamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static String[] Graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Graph = new String[N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            Graph[i] = tmp;
        }

        int K = Integer.parseInt(br.readLine());
        int flag = K % 2; // 짝수인지 홀수인지 판단

        for (int i = 0; i < N; i++) {
            int offCount = 0;
            for (int j = 0; j < M; j++) {
                if (Graph[i].charAt(j) == '0') {
                    offCount++;
                }
            }
            if (offCount % 2 != flag) {
                continue; //만약 offCount가 flag와 홀짝이 다르면 스킵
            }

            if (offCount <= K && map.get(Graph[i]) > max) {
                max = map.get(Graph[i]);
            }
        }
        System.out.println(max);
    }

}
