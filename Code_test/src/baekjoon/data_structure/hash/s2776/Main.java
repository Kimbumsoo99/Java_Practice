package baekjoon.data_structure.hash.s2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int A = Integer.parseInt(st.nextToken());
                if (!set.contains(A)) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}