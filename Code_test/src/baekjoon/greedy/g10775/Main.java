package baekjoon.greedy.g10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int parents[], G, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        makeSet();
        boolean flag = false;
        int answer = 0;
        for (int i = 0; i < P; i++) {
            int N = Integer.parseInt(br.readLine());
            if (flag)
                continue;
            if (findSet(N) == 0) {
                flag = true;
                continue;
            }
            answer++;
            unionSet(findSet(N) - 1, findSet(N));

        }
        System.out.println(answer);
    }

    static void makeSet() {
        parents = new int[G + 1];
        for (int i = 0; i < G + 1; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = findSet(parents[x]);
    }

    static boolean unionSet(int x, int p) {
        if (x == p)
            return false;
        if (x < p) {
            int tmp = p;
            p = x;
            x = tmp;
        }
        parents[x] = p;
        return true;
    }
}
