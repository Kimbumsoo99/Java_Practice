package baekjoon.implementations.silver.s2535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static class Student {

        int country;
        int stNum;
        int score;

        public Student(int country, int stNum, int score) {
            this.country = country;
            this.stNum = stNum;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new Student(c, n, s));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Collections.sort(list, (o1, o2) -> {
            return o2.score - o1.score;
        });
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Student student : list) {
            if (count == 3) {
                break;
            }
            if (map.containsKey(student.country) && map.get(student.country) > 1) {
                continue;
            } else {
                map.put(student.country, map.getOrDefault(student.country, 0) + 1);
                sb.append(student.country).append(" ").append(student.stNum).append("\n");
                count++;
            }
        }
        System.out.println(sb);
    }
}
