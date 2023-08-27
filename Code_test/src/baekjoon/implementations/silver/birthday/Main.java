package baekjoon.implementations.silver.birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class People{
        String name;
        int day;
        int month;
        int year;

        public People(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<People> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new People(name, day, month, year));
        }
        Collections.sort(list, ((o1, o2) -> {
            if (o1.year == o2.year) {
                if (o1.month == o2.month) {
                    return o1.day - o2.day;
                }
                return o1.month - o2.month;
            }
            return o1.year - o2.year;
        }));

        System.out.println(list.get(N - 1).name + "\n" + list.get(0).name);
    }
}
