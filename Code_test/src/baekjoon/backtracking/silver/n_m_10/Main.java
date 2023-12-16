package baekjoon.backtracking.silver.n_m_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] s;
    static ArrayList<String> answer = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        s = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);
        tracking(0, N, M, new ArrayList<Integer>());
        StringBuilder sb = new StringBuilder();
        for (String ans : answer) {
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void tracking(int current, int n, int m, ArrayList<Integer> list) {
//        for (Integer draw : list) {
//            System.out.print(draw + " ");
//        }
//        System.out.println();
        if (list.size() == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer e : list) {
                sb.append(e + " ");
            }
            String tmp = sb.toString();
            if (!set.contains(tmp)) {
                set.add(tmp);
                answer.add(tmp);
            }
            return;
        }

        for (int i = current; i < n; i++) {
            list.add(s[i]);
            tracking(i + 1, n, m, list);
            list.remove(list.size() - 1);
        }
    }

}
