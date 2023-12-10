package baekjoon.implementations.silver.s1235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String tmp = br.readLine();
                list.add(tmp);
            }
            int idx = list.get(0).length() - 1;
            boolean flag;
            int answer = 0;
            while (true) {
                HashMap<String, Integer> map = new HashMap<>();
                flag = true;
                for (String s : list) {
                    String tmp = s.substring(idx);
                    if (map.containsKey(tmp)) {
                        flag = false;
                        break;
                    }
                    answer = tmp.length();
                    map.put(tmp, 1);
                }
                if (flag) {
                    System.out.println(answer);
                    return;
                }
                idx--;
            }
        }

}
