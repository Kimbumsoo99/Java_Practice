package swea.proB.day1.d_practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if ("I".equals(cmd)) {
                    int idx = Integer.parseInt(st.nextToken());
                    int val = Integer.parseInt(st.nextToken());
                    list.add(idx, val);
                } else if ("D".equals(cmd)) {
                    int idx = Integer.parseInt(st.nextToken());
                    list.remove(idx);
                } else {
                    int idx = Integer.parseInt(st.nextToken());
                    int val = Integer.parseInt(st.nextToken());
                    list.set(idx, val);
                }
            }

            answer = list.size() < L + 1 ? -1 : list.get(L);
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
