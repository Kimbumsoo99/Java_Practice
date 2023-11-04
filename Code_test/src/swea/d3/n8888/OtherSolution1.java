package swea.d3.n8888;

import java.io.*;
import java.util.*;

public class OtherSolution1 {
    static class Person {

        int id;
        int score;
        int count;

        public Person(int id, int score, int count) {
            this.id = id;
            this.score = score;
            this.count = count;
        }
    }

    static Comparator<Person> rankComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            if (p1.score == p2.score) {
                if (p1.count == p2.count) {
                    return p1.id - p2.id;
                } else {
                    return p2.count - p1.count;
                }
            } else {
                return p2.score - p1.score;
            }
        }
    };

    static boolean[][] ox = new boolean[2000][2000];
    static int[] score = new int[2000];
    static int[] count = new int[2000];
    static int[] test = new int[2000];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            init();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            parseData(n, t, br);
            computeScore(n, t);
            List<Person> people = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                people.add(new Person(i + 1, score[i], count[i]));
            }
            people.sort(rankComparator);

            Iterator<Person> it = people.iterator();
            int rank = 0;
            while (it.hasNext()) {
                rank++;
                Person person = it.next();
                if (person.id == p) {
                    break;
                }
            }

            System.out.println("#" + test_case + " " + score[p - 1] + " " + rank);
        }
    }


    private static void parseData(int n, int t, BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < t; j++) {
                boolean result = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                ox[i][j] = result;

                if (result) {
                    count[i]++;
                } else {
                    test[j]++;
                }
            }
        }
    }

    private static void computeScore(int n, int t) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < t; j++) {
                if (ox[i][j]) {
                    score[i] += test[j];
                }
            }
        }
    }

    private static void init() {
        Arrays.fill(score, 0);
        Arrays.fill(count, 0);
        Arrays.fill(test, 0);
    }
}
