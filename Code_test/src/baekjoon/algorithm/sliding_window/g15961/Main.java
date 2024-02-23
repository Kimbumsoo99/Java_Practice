package baekjoon.algorithm.sliding_window.g15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, c, k, d, arr[];
    static int[] visit = new int[3001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = k;
        int cnt = 1;
        visit[c] += 1;
        for (int i = start; i < end; i++) {
            if (visit[arr[i]] == 0) {
                cnt++;
            }
            visit[arr[i]]++;
        }

        int answer = cnt;
        while (start < N-1) {
            if(answer <= cnt){
                if(visit[c] == 0){
                    answer = cnt+1;
                }else {
                    answer = cnt;
                }
            }
            visit[arr[start]]--;
            if (visit[arr[start]] == 0) {
                cnt--;
            }
            if (visit[arr[end % N]] == 0) {
                cnt++;
            }
            visit[arr[end % N]]++;
            answer = Math.max(answer, cnt);
            end++;
            start++;
        }
        System.out.println(answer);
    }
}
