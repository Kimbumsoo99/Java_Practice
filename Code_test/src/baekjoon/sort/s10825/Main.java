package baekjoon.sort.s10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class People{
        String name;
        int g;
        int s;
        int o;

        public People(String name, int g, int o, int s) {
            this.name = name;
            this.g = g;
            this.s = s;
            this.o = o;
        }
    }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            ArrayList<People> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String tmp = st.nextToken();
                int g = Integer.parseInt(st.nextToken());
                int o = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list.add(new People(tmp, g, o, s));
            }
            // o1 - o2는 오름차 순
            // o2 - o1은 내림차 순
            Collections.sort(list, (o1, o2) -> {
                if (o1.g != o2.g) {
                    return o2.g - o1.g;
                }
                else if (o1.o != o2.o) {
                    return o1.o - o2.o;
                }
                else if (o1.s != o2.s) {
                    return o2.s - o1.s;
                }
                return o1.name.compareTo(o2.name);
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(list.get(i).name).append("\n");
            }
            System.out.println(sb);
        }

}
