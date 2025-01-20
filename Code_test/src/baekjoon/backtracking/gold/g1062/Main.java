package baekjoon.backtracking.gold.g1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int flag, N, K, answer = 0;
    static int[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        flag = 532741; // a, n, t, c, i
        words = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                tmp |= (1 << (str.charAt(j) - 'a'));
            }
//            System.out.println(tmp);
            words[i] = tmp;
        }

        dfs(0, 5);
        System.out.println(answer);
    }

    static void dfs(int start, int cnt) {
        int ans = 0;

        if (cnt == K) {
            for (int i = 0; i < N; i++) {
                if ((flag & words[i]) == words[i]) {
                    ans++;
                }
            }
            answer = Math.max(ans, answer);
            return;
        }

        for (int i = start; i < 26; i++) {
            if((flag & (1 << i)) == 0) {
                flag |= (1 << i);
                dfs(i + 1, cnt + 1);
                flag &= ~(1 << i);
            }
        }
    }
}