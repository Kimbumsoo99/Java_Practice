package baekjoon.implementations.bronze.b13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시험 감독 브 2
// 삼성 역량
public class Main {
    static int[] supervise;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        supervise = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            supervise[i] = tmp;
        }
        st = new StringTokenizer(br.readLine());
        int totalSupervisor = Integer.parseInt(st.nextToken());
        int assistantSupervisor = Integer.parseInt(st.nextToken());

        long answer = 0;

        for (int i = 0; i < N; i++) {
            supervise[i] -= totalSupervisor;
            answer++;
            if(supervise[i] > 0){
                answer += supervise[i] / assistantSupervisor;
                if(supervise[i] % assistantSupervisor != 0) answer++;
            }
        }
        System.out.println(answer);

    }
}
