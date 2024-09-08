package baekjoon.dp.s1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, dp[];
    static HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        N = n;
        int m = Integer.parseInt(st.nextToken());
        dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(new int[]{a, c});
        }

        for (int i = 1; i <= m; i++) {
            dp[i] = dp[i - 1] + 1;

            if(map.containsKey(i)) {
                for (int[] s : map.get(i)) {
                    dp[i] = Math.min(dp[i], dp[s[0]] + s[1]);
                }
            }
        }

        System.out.println(dp[m]);
    }
}
