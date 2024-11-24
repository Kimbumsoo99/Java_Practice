package baekjoon.data_structure.union_find.g16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents, pay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // make
        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }

        pay = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
        }

        while (M-->0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            union(A, B);
        }

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            int idx = find(i);

            if (visited[idx]) {
                visited[i] = true;
                continue;
            }

            sum += pay[idx];
            visited[idx] = true;
            visited[i] = true;
        }

        if (sum > K)
            System.out.println("Oh no");
        else
            System.out.println(sum);
    }

    static int find(int x) {
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pay[pA] >= pay[pB]) {
            parents[pA] = parents[pB];
        } else {
            parents[pB] = parents[pA];
        }
    }
}