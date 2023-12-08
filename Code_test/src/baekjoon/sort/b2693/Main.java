package baekjoon.sort.b2693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int test_case = 0; test_case < T; test_case++) {
                ArrayList<Integer> list = new ArrayList<>();
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < 10; i++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
                Collections.sort(list);
                sb.append(list.get(7)).append("\n");
            }
            System.out.println(sb);

        }

}
