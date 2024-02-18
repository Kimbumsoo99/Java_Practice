package baekjoon.greedy.g11509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visit = new int[1_000_002];
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (visit[tmp + 1] == 0) {
                count++;
                visit[tmp]++;
            } else {
                visit[tmp + 1]--;
                visit[tmp]++;
            }
        }
        System.out.println(count);
    }
}
